package com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String order_num;
    private LocalDateTime createdAt;
    private Double order_total;

    @JsonIgnore
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private List<OrderDetail> details;
}
