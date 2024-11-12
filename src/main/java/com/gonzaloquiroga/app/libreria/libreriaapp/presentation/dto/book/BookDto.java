package com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto  implements Serializable {
    private Long id;
    private String name;
    private String author;
    private String category;
    private Double price;
    private LocalDateTime registeredAt;
    private String img;
    private Integer stock;

}
