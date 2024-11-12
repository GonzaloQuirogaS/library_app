package com.gonzaloquiroga.app.libreria.libreriaapp.service.interfaces;

import com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.order.OrderDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.order.SaveOrderDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.Order;

import java.util.List;

public interface IOrderService {

    List<OrderDto> findAll();

    OrderDto saveDto(SaveOrderDto saveOrderDto);

    Order save(Order order);


    Order findById(Long id);

}
