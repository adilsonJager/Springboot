package com.example.springbooth2.Dto.Author;

import com.example.springbooth2.Dto.Book.BookSimplesDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public record AuthorwithlistResponseDto(Long id, String name, List<BookSimplesDto> books) {

}
