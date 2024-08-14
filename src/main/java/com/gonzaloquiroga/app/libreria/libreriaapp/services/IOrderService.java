package com.gonzaloquiroga.app.libreria.libreriaapp.services;

import com.gonzaloquiroga.app.libreria.libreriaapp.dto.order.OrderDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.dto.order.SaveOrderDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.Order;

import java.util.List;

public interface IOrderService {

    List<OrderDto> findAll();

    OrderDto saveDto(SaveOrderDto saveOrderDto);

    Order save(Order order);


    Order findById(Long id);

}
