package com.gonzaloquiroga.app.libreria.libreriaapp.services;

import com.gonzaloquiroga.app.libreria.libreriaapp.dto.orderDetail.OrderDetailDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.OrderDetail;

import java.util.List;

public interface IOrderDetailService {

    List<OrderDetailDto> findAll();

    OrderDetailDto save(OrderDetail orderDetail);

}
