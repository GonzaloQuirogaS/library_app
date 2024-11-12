package com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.order;

import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.OrderDetail;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveOrderDto implements Serializable {

    private String order_num;
    private Double order_total;
    private User user;
    private List<OrderDetail> details;
}
