package com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Double price;

    @ManyToOne
    private Book book;

    @JsonIgnore
    @ManyToOne
    private Order order;

}
