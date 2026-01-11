package com.example.springbooth2.Dto.Book;

import lombok.Data;

@Data
public class BookCreatDto {
    private String name;
    private Long authorId; // opcional
}