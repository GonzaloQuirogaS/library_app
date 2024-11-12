package com.gonzaloquiroga.app.libreria.libreriaapp.utils.mapper;

import com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.book.BookDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.Book;
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
