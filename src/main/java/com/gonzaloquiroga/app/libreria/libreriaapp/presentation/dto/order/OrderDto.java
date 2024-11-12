package com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.order;

import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Serializable {

    private Long id;
    private String order_num;
    private LocalDateTime createdAt;
    private Double order_total;
    private String user;
    private List<OrderDetail> details;
}
