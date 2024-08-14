package com.gonzaloquiroga.app.libreria.libreriaapp.controllers;

import com.gonzaloquiroga.app.libreria.libreriaapp.dto.user.SaveUserDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.dto.user.UserDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.Order;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.OrderDetail;
import com.gonzaloquiroga.app.libreria.libreriaapp.services.IBookService;
import com.gonzaloquiroga.app.libreria.libreriaapp.services.IOrderDetailService;
import com.gonzaloquiroga.app.libreria.libreriaapp.services.IOrderService;
import com.gonzaloquiroga.app.libreria.libreriaapp.services.IUserService;
import com.gonzaloquiroga.app.libreria.libreriaapp.utils.Utils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.gonzaloquiroga.app.libreria.libreriaapp.constants.PathConstants.*;
import static com.gonzaloquiroga.app.libreria.libreriaapp.constants.ErrorConstants.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
public class UserController {

    private final Utils utils;

    private final IUserService userService;

    private final IBookService bookService;

    private final IOrderService orderService;

    private final IOrderDetailService orderDetailService;

    //Inicializamos una lista de detalles vacia de forma global para realizar operaciones sobre ella
    List<OrderDetail> details = new ArrayList<>();

    //Creamos una orden vacia de forma global para para realizar operaciones sobre ella
    Order order = new Order();

    //Metodo que añade un libro del carrito recibiendo como parametro su id
    @PostMapping(CART)
    @Tag(name = "USER ", description = "USER Mehtods")
    @Operation(summary = "Add book to cart by ID")
    private ResponseEntity<?> addCart(@PathVariable Long id) {
        try {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setBook(bookService.findById(id));
            orderDetail.setTotal_price(bookService.findByIdDto(id).getPrice());
            orderDetail.setPrice(bookService.findByIdDto(id).getPrice());
            details.add(orderDetail);
            double sumaTotal;
            sumaTotal = details.stream().mapToDouble(OrderDetail::getTotal_price).sum();
            order.setOrder_total(sumaTotal);
            return ResponseEntity.ok(details.stream().map(OrderDetail::getBook));
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest().body(BOOK_NOT_FOUND_CART);
        }
    }

    //Metodo que elimina un libro del carrito recibiendo como parametro su id
    @DeleteMapping(DELETE_CART_ITEM)
    @Tag(name = "USER ")
    @Operation(summary = "Delete book from cart by ID")
    private ResponseEntity<?> deleteCart(@PathVariable Long id) {
        try {
            List<OrderDetail> newOrders = new ArrayList<>();
            for (OrderDetail orderDetail : details) {
                if (!orderDetail.getBook().getId().equals(id)) {
                    newOrders.add(orderDetail);
                }
            }
            details = newOrders;
            double sumaTotal;
            sumaTotal = details.stream().mapToDouble(OrderDetail::getTotal_price).sum();
            order.setOrder_total(sumaTotal);
            return ResponseEntity.ok(details.stream().map(OrderDetail::getBook));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BOOK_NOT_FOUND_CART);
        }
    }

    @GetMapping(GET_CART)
    @Tag(name = "USER ")
    @Operation(summary = "Get cart")
    private ResponseEntity<?> getCart() {
        try {
            if (!details.isEmpty()) {
                return ResponseEntity.ok(details.stream().map(OrderDetail::getBook));
            }
            return ResponseEntity.badRequest().body(EMPTY_CART);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(EMPTY_CART);
        }
    }

    //Metodo que guarda una orden
    @PostMapping(SAVE_ORDER)
    @Tag(name = "USER ")
    @Operation(summary = "Create an order")
    private ResponseEntity<?> save() {
        try {
            order.setUser(utils.getUser());
            orderService.save(order);
            for (OrderDetail dt : details) {
                dt.setUsername(utils.getUser().getUsername());
                dt.setUsersurname(utils.getUser().getUsersurname());
                dt.setEmail(utils.getUser().getEmail());
                dt.setPhone(utils.getUser().getPhone());
                dt.setCountry(utils.getUser().getCountry());
                dt.setDistrict(utils.getUser().getDistrict());
                dt.setAdress(utils.getUser().getAdress());
                dt.setPcode(utils.getUser().getPcode());
                dt.setOrder(order);
                orderDetailService.save(dt);
            }
            Order order1 = order;
            order = new Order();
            details.clear();
            return ResponseEntity.ok(order1);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ORDER_SAVE_ERROR);
        }
    }

    //Metodo para ver los datos del usuario logueado
    @GetMapping
    @Tag(name = "USER ")
    @Operation(summary = "Find logged user")
    private ResponseEntity<?> findUserById() {
        try {
            return ResponseEntity.ok(userService.findById(utils.getUser().getId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(USER_NOT_FOUND);
        }
    }

    //Metodo para actualizar al usuario logeado
    @PutMapping(UPDATE)
    @Tag(name = "USER ")
    @Operation(summary = "Update logged user")
    private ResponseEntity<?> updateUser(@RequestBody SaveUserDto user) {
        try {
            return ResponseEntity.ok(userService.updateById(user, utils.getUser().getId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(USER_NOT_FOUND);
        }
    }

    //Metodo para ver todas las ordenes del usuario logueado
    @GetMapping(GET_USER_ORDER)
    @Tag(name = "USER ")
    @Operation(summary = "View user orders")
    private ResponseEntity<?> findUserOrdersById() {
        try {
            UserDto userBd = userService.findById(utils.getUser().getId());
            List<Order> userOrders = userBd.getOrders();
            return ResponseEntity.ok(userOrders);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ORDER_NOT_FOUND);
        }
    }

    //Metodo para ver una orden por su id
    @GetMapping(GET_USER_ORDER_ID)
    @Tag(name = "USER ")
    @Operation(summary = "View user order")
    private ResponseEntity<?> findUserOrderById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(orderService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ORDER_NOT_FOUND);
        }
    }

    //Metodo para ver un detalle de orden por su id de orden
    @GetMapping(GET_USER_ORDER_DETAIL_ID)
    @Tag(name = "USER ")
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
