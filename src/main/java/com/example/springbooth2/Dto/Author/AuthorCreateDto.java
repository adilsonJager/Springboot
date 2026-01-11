package com.example.springbooth2.Dto.Author;

public class AuthorCreateDto {

        private Long id;
        private String name;


    public AuthorCreateDto() {
    }

    public AuthorCreateDto(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public String getName() {
        return name;
    }


    public Long getId() {
        return id;
    }
}
