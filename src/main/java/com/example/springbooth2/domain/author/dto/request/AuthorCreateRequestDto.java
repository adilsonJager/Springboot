package com.example.springbooth2.domain.author.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AuthorCreateRequestDto(
        @NotBlank(message = "Name must not be empty") String name,
        @NotBlank(message = "Email must not be empty") String email,
        @NotBlank(message = "Password must not be empty") String password
) { }
