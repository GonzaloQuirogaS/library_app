package com.gonzaloquiroga.app.libreria.libreriaapp.utils;

import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

//Clase Utils donde hay metodos que nos puedan ser de utilidad
@Service
public class Utils {

    //Metodo getUser() que nos trae los datos del usuario logeado
    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
    }

    //Metodo validation() que se encarga de validar los datos ingresados
    public ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

}
