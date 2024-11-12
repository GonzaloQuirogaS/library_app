package com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.orderDetail;

import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.Book;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto implements Serializable {

    private Long id;
    private String username;
    private String usersurname;
    private String email;
    private String password;
    private String phone;
    private String country;
    private String district;
    private String adress;
    private String pcode;
    private Double total_price;
    private Book book;
    private Order order;
}
