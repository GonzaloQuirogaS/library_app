package com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.user;

import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.enums.Role;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String username;
    private String usersurname;
    private String email;
    private String phone;
    private String country;
    private String district;
    private String adress;
    private String pcode;
    private Role role;
    private LocalDateTime registeredAt = LocalDateTime.now();
    private List<Order> orders;
}
