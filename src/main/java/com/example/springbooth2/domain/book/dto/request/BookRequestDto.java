package com.example.springbooth2.domain.book.dto.request;
import jakarta.validation.constraints.NotBlank;

public record BookRequestDto (
        @NotBlank(message = "Name must not be empty") String name,
        @NotBlank(message = "Author Id must not be empty") String authorId
){ }
