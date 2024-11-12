package com.gonzaloquiroga.app.libreria.libreriaapp.presentation.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveBookDto implements Serializable {
    private String name;
    private String author;
    private String category;
    private Double price;
    private String img;
    private Integer stock;
}
