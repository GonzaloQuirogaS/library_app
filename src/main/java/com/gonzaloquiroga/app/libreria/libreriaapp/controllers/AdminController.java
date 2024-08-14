package com.gonzaloquiroga.app.libreria.libreriaapp.controllers;

import com.gonzaloquiroga.app.libreria.libreriaapp.dto.book.BookDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.dto.book.SaveBookDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.dto.user.UserDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.Order;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.OrderDetail;
import com.gonzaloquiroga.app.libreria.libreriaapp.services.IBookService;
import com.gonzaloquiroga.app.libreria.libreriaapp.services.IOrderService;
import com.gonzaloquiroga.app.libreria.libreriaapp.services.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.gonzaloquiroga.app.libreria.libreriaapp.constants.PathConstants.*;
import static com.gonzaloquiroga.app.libreria.libreriaapp.constants.ErrorConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ADMIN)
public class AdminController {

    private final IUserService userService;
    private final IBookService bookService;
    private final IOrderService orderService;

    //Metodo para ver usuario por id
    @GetMapping(GET_USER)
    @Tag(name = "ADMIN ", description = "ADMIN Methods")
    @Operation(summary = "Get user")
    private ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            UserDto user = userService.findById(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(USER_NOT_FOUND);
        }
    }

    //Metodo para ver todos los usuarios
    @GetMapping(GET_USERS)
    @Tag(name = "ADMIN ")
    @Operation(summary = "Get all users")
    private ResponseEntity<?> findAllUsers() {
        try {
            return ResponseEntity.ok(userService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(USERS_NOT_FOUND);
        }
    }

    //Metodo para eliminar usuario por id
    @DeleteMapping(DELETE_USER)
    @Tag(name = "ADMIN ")
    @Operation(summary = "Delete user")
    private ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(USER_DELETE_ERROR);
        }
    }

    //Metodo para ver todos los libros registrados
    @GetMapping(GET_BOOKS)
    @Tag(name = "ADMIN ")
    @Operation(summary = "Get all books")
    private ResponseEntity<?> findAllBooks() {
        try {
            return ResponseEntity.ok(bookService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BOOKS_NOT_FOUND);
        }
    }

    //Metodo para registrar libro nuevo
    @PostMapping(SAVE_BOOK)
    @Tag(name = "ADMIN ")
    @Operation(summary = "Create book")
    private ResponseEntity<?> saveBook(@RequestBody SaveBookDto saveBookDto) {
        try {
            return ResponseEntity.ok(bookService.saveDto(saveBookDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BOOK_SAVE_ERROR);
        }
    }

    //Metodo para eliminar libro
    @DeleteMapping(DELETE_BOOK)
    @Tag(name = "ADMIN ")
    @Operation(summary = "Delete book")
    private ResponseEntity<?> deleteBook(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(bookService.deleteById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BOOK_DELETE_ERROR);
        }
    }

    //Metodo para ver libro por su id
    @GetMapping(GET_BOOK)
    @Tag(name = "ADMIN ")
    @Operation(summary = "Get book")
    private ResponseEntity<?> getBookById(@PathVariable Long id) {
        try {
            BookDto book = bookService.findByIdDto(id);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BOOK_NOT_FOUND);
        }
    }

    //Metodo para actualizar libro por su id
    @PutMapping(UPDATE_BOOK)
    @Tag(name = "ADMIN ")
    @Operation(summary = "Update book")
    private ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody SaveBookDto saveBookDto) {
        try {
            BookDto book = bookService.update(id, saveBookDto);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BOOK_UPDATE_ERROR);
        }
    }

    //Metodo para obtener todas las ordenes
    @GetMapping(GET_USER_ORDER)
    @Tag(name = "ADMIN ")
    @Operation(summary = "Get all orders")
    private ResponseEntity<?> getOrders() {
        try {
            return ResponseEntity.ok(orderService.findAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BOOK_NOT_FOUND);
        }
    }

    //Metodo para obtener orden por su id
    @GetMapping(GET_USER_ORDER_ID)
    @Tag(name = "ADMIN ")
    @Operation(summary = "View order")
    private ResponseEntity<?> findUserOrderById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(orderService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ORDER_NOT_FOUND);
        }
    }

    //Metodo para obtener orden detail por su id de orden
    @GetMapping(GET_USER_ORDER_DETAIL_ID)
    @Tag(name = "ADMIN ")
    @Operation(summary = "View order detail")
    private ResponseEntity<?> findUserOrderDetailById(@PathVariable Long id) {
        try {
            Order order = orderService.findById(id);
            List<OrderDetail> orderDetail = order.getDetails();
            return ResponseEntity.ok(orderDetail);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ORDER_DETAIL_NOT_FOUND);
        }
    }
}
