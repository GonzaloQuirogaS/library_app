package com.gonzaloquiroga.app.libreria.libreriaapp.presentation.auth;

import com.gonzaloquiroga.app.libreria.libreriaapp.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.gonzaloquiroga.app.libreria.libreriaapp.utils.constant.PathConstants.*;
import static com.gonzaloquiroga.app.libreria.libreriaapp.utils.constant.ErrorConstants.*;


@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final Utils utils;

    private final AuthService authService;

    @Tag(name = "AUTH", description = "AUTH Methods")
    @Operation(summary = "Login")
    @PostMapping(LOGIN)
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request, BindingResult result) {
        try {
            if (result.hasFieldErrors()) {
                return utils.validation(result);
            }
            return ResponseEntity.ok(authService.login(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(INVALID_LOGIN);
        }
    }

    @Tag(name = "AUTH")
    @Operation(summary = "Register")
    @PostMapping(REGISTER)
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest request, BindingResult result) {
        try {
            if (result.hasFieldErrors()) {
                return utils.validation(result);
            }
            return ResponseEntity.ok(authService.register(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(INVALID_REGISTER);
        }
    }
}