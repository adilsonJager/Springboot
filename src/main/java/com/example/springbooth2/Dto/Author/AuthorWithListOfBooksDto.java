package com.example.springbooth2.Dto.Author;

import com.example.springbooth2.Dto.Book.BookSimplesDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorWithListOfBooksDto {

    private Long id;
    private String name;

    private List<BookSimplesDto> books = new ArrayList<>();

    public AuthorWithListOfBooksDto() {
    }

    public AuthorWithListOfBooksDto(String name) {
        this.name = name;
    }


}
