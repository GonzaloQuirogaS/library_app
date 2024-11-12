package com.gonzaloquiroga.app.libreria.libreriaapp.persistence.repository;

import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
