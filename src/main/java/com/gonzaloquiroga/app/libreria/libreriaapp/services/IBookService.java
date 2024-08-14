package com.gonzaloquiroga.app.libreria.libreriaapp.services;

import com.gonzaloquiroga.app.libreria.libreriaapp.dto.book.BookDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.dto.book.SaveBookDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.Book;

import java.util.List;

public interface IBookService {

    BookDto saveDto(SaveBookDto saveBookDto);
    List<BookDto> findAll();

    BookDto deleteById(Long id);

    BookDto findByIdDto(Long id);

    Book findById(Long id);

    BookDto update(Long id,SaveBookDto saveBookDto);

}
