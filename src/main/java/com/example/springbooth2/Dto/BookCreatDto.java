package com.example.springbooth2.Dto;

import lombok.Data;

@Data
public class BookCreatDto {
    private String name;
    private Long authorId; // opcional
}