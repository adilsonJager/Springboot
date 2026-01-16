package com.example.springbooth2.domain.author.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AuthorUpdateRequestDto (
        @NotBlank(message = "Name must not be empty") String name
) {
}
