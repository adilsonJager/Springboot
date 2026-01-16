package com.example.springbooth2.domain.author.dto.response;

import com.example.springbooth2.domain.book.dto.response.BookSimplesResponseDto;
import java.util.List;


public record AuthorwithlistResponseDto(
        String id,
        String name,
        List<BookSimplesResponseDto> books) {

}
