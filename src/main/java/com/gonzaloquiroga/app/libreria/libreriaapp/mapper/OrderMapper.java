package com.gonzaloquiroga.app.libreria.libreriaapp.mapper;

import com.gonzaloquiroga.app.libreria.libreriaapp.dto.order.OrderDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public OrderDto mapToOrderDto(Order order) {
        if (order == null) return null;
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setOrder_num(order.getOrder_num());
        orderDto.setOrder_total(order.getOrder_total());
        orderDto.setDetails(order.getDetails());
        orderDto.setCreatedAt(order.getCreatedAt());
        orderDto.setUser(order.getUser().getUsername() + " " + order.getUser().getUsersurname());
        return orderDto;
    }
}
