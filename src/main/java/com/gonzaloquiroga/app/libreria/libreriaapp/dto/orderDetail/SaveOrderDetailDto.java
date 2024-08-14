package com.gonzaloquiroga.app.libreria.libreriaapp.dto.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveOrderDetailDto implements Serializable {
    private Long id;
    private String username;
    private String usersurname;
    private String email;
    private String phone;
    private String country;
    private String district;
    private String adress;
    private String pcode;
    private Double total_price;
}
