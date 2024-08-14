package com.gonzaloquiroga.app.libreria.libreriaapp.mapper;

import com.gonzaloquiroga.app.libreria.libreriaapp.dto.orderDetail.OrderDetailDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.OrderDetail;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailMapper {
    public OrderDetailDto mapToOrderDetailDto(OrderDetail orderDetail) {
        if (orderDetail == null) return null;

        OrderDetailDto orderDetailDto = new OrderDetailDto();
        orderDetailDto.setId(orderDetail.getId());
        orderDetailDto.setUsername(orderDetail.getUsername());
        orderDetailDto.setUsersurname(orderDetail.getUsersurname());
        orderDetailDto.setEmail(orderDetail.getEmail());
        orderDetailDto.setPhone(orderDetail.getPhone());
        orderDetailDto.setCountry(orderDetail.getCountry());
        orderDetailDto.setDistrict(orderDetail.getDistrict());
        orderDetailDto.setAdress(orderDetail.getAdress());
        orderDetailDto.setPcode(orderDetail.getPcode());
        orderDetailDto.setBook(orderDetail.getBook());
        orderDetailDto.setTotal_price(orderDetail.getTotal_price());
        orderDetailDto.setOrder(orderDetail.getOrder());
        return orderDetailDto;
    }

}
