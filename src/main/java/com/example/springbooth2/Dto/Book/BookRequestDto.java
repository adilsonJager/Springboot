package com.example.springbooth2.Dto.Book;

import org.antlr.v4.runtime.misc.NotNull;

public class BookRequestDto {


    private String name;
    @NotNull
    private Long authorId;

    public BookRequestDto(String name, Long authorId) {
        this.name = name;
        this.authorId = authorId;
    }

    public BookRequestDto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
