package com.gonzaloquiroga.app.libreria.libreriaapp.service.interfaces;

import com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.orderDetail.OrderDetailDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.OrderDetail;

import java.util.List;

public interface IOrderDetailService {

    List<OrderDetailDto> findAll();

    OrderDetailDto save(OrderDetail orderDetail);

}
