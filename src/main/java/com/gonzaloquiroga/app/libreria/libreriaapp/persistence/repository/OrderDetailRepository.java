package com.gonzaloquiroga.app.libreria.libreriaapp.persistence.repository;

import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
