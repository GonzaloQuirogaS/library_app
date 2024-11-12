package com.gonzaloquiroga.app.libreria.libreriaapp.service.interfaces;

import com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.book.BookDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.book.SaveBookDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.Book;

import java.util.List;

public interface IBookService {

    BookDto saveDto(SaveBookDto saveBookDto);
    List<BookDto> findAll();

    BookDto deleteById(Long id);

    BookDto findByIdDto(Long id);

    Book findById(Long id);

    BookDto update(Long id,SaveBookDto saveBookDto);

}
