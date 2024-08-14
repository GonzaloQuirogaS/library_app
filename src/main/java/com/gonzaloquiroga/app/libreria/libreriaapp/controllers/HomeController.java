package com.gonzaloquiroga.app.libreria.libreriaapp.controllers;

import com.gonzaloquiroga.app.libreria.libreriaapp.services.IBookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gonzaloquiroga.app.libreria.libreriaapp.constants.PathConstants.*;
import static com.gonzaloquiroga.app.libreria.libreriaapp.constants.ErrorConstants.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(HOME)
public class HomeController {

    private final IBookService bookService;

    //Metodo para ver todos los libros registrados
    @GetMapping
    @Tag(name = "HOME", description = "HOME Methods")
    private ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    //Metodo para ver libro por id
    @GetMapping(GET_BOOK_BY_ID)
    @Tag(name = "HOME")
    private ResponseEntity<?> findBookById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(bookService.findByIdDto(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BOOK_NOT_FOUND);
        }
    }
}
