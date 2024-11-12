package com.gonzaloquiroga.app.libreria.libreriaapp.service.servicesImpl;

import com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.book.BookDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.book.SaveBookDto;
import com.gonzaloquiroga.app.libreria.libreriaapp.utils.mapper.BookMapper;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.Book;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.repository.BookRepository;
import com.gonzaloquiroga.app.libreria.libreriaapp.service.interfaces.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    private final BookRepository bookRepository;

    private final BookMapper mapper;

    @Override
    public BookDto saveDto(SaveBookDto saveBookDto) {
        Book book = new Book();
        book.setName(saveBookDto.getName());
        book.setAuthor(saveBookDto.getAuthor());
        book.setRegisteredAt(LocalDateTime.now());
        book.setPrice(saveBookDto.getPrice());
        book.setImg(saveBookDto.getImg());
        book.setCategory(saveBookDto.getCategory());
        book.setStock(saveBookDto.getStock());

        bookRepository.save(book);
        return mapper.mapToBookDto(book);
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(mapper::mapToBookDto).collect(Collectors.toList());
    }

    @Override
    public BookDto deleteById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        bookRepository.deleteById(id);
        return mapper.mapToBookDto(book);
    }

    @Override
    public BookDto findByIdDto(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        return mapper.mapToBookDto(book);
    }

    @Override
    public Book findById(Long id) {

        return bookRepository.findById(id).orElseThrow();

    }

    @Override
    public BookDto update(Long id, SaveBookDto saveBookDto) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setAuthor(saveBookDto.getAuthor());
        book.setName(saveBookDto.getName());
        book.setPrice(saveBookDto.getPrice());
        book.setCategory(saveBookDto.getCategory());
        book.setImg(saveBookDto.getImg());
        book.setStock(saveBookDto.getStock());

        bookRepository.save(book);

        return mapper.mapToBookDto(book);
    }
}
