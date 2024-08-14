package com.gonzaloquiroga.app.libreria.libreriaapp.mapper;

import com.gonzaloquiroga.app.libreria.libreriaapp.dto.book.BookDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entities.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public BookDto mapToBookDto(Book book) {
        if (book == null) return null;

        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setCategory(book.getCategory());
        bookDto.setRegisteredAt(book.getRegisteredAt());
        bookDto.setImg(book.getImg());
        bookDto.setPrice(book.getPrice());
        bookDto.setStock(book.getStock());

        return bookDto;
    }
}
