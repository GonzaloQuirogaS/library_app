package com.gonzaloquiroga.app.libreria.libreriaapp.services.servicesImpl;

import com.gonzaloquiroga.app.libreria.libreriaapp.dto.order.OrderDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.dto.order.SaveOrderDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.mapper.OrderMapper;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.Order;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.repository.OrderRepository;
import com.gonzaloquiroga.app.libreria.libreriaapp.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//Clase de servicio para las ordenes
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;

    @Override
    public List<OrderDto> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(mapper::mapToOrderDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto saveDto(SaveOrderDto saveOrderDto) {
        Order order = new Order();
        order.setOrder_num(saveOrderDto.getOrder_num());
        order.setOrder_total(saveOrderDto.getOrder_total());
        order.setCreatedAt(LocalDateTime.now());
        order.setDetails(saveOrderDto.getDetails());
        order.setUser(saveOrderDto.getUser());
        orderRepository.save(order);
        return mapper.mapToOrderDto(order);
    }

    @Override
    public Order save(Order order) {

        String number = UUID.randomUUID().toString();
        order.setOrder_num(number);
        order.setCreatedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }


    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }
}
