package com.gonzaloquiroga.app.libreria.libreriaapp.persistence.repository;

import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
