package com.gonzaloquiroga.app.libreria.libreriaapp.services.servicesImpl;

import com.gonzaloquiroga.app.libreria.libreriaapp.dto.orderDetail.OrderDetailDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.mapper.OrderDetailMapper;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.OrderDetail;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.repository.OrderDetailRepository;
import com.gonzaloquiroga.app.libreria.libreriaapp.services.IOrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements IOrderDetailService {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderDetailMapper mapper;

    @Override
    public List<OrderDetailDto> findAll() {
        List<OrderDetail> orderDetails = orderDetailRepository.findAll();
        return orderDetails.stream().map(mapper::mapToOrderDetailDto).collect(Collectors.toList());
    }

    @Override
    public OrderDetailDto save(OrderDetail orderDetail) {
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setUsername(orderDetail.getUsername());
        orderDetail1.setUsersurname(orderDetail.getUsersurname());
        orderDetail1.setEmail(orderDetail.getEmail());
        orderDetail1.setPhone(orderDetail.getPhone());
        orderDetail1.setCountry(orderDetail.getCountry());
        orderDetail1.setDistrict(orderDetail.getDistrict());
        orderDetail1.setAdress(orderDetail.getAdress());
        orderDetail1.setPcode(orderDetail.getPcode());
        orderDetail1.setPrice(orderDetail.getPrice());
        orderDetail1.setTotal_price(orderDetail.getTotal_price());
        orderDetail1.setBook(orderDetail.getBook());
        orderDetail1.setOrder(orderDetail.getOrder());

        orderDetailRepository.save(orderDetail1);
        return mapper.mapToOrderDetailDto(orderDetail1);
    }
}
