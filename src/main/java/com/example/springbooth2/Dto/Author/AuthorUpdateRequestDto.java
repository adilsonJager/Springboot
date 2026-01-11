package com.example.springbooth2.Dto.Author;

public class AuthorUpdateRequestDto {

    private String name;


    public AuthorUpdateRequestDto() {
    }

    public AuthorUpdateRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
