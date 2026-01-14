package com.example.springbooth2.Dto.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


public record BookResponseDto (Long id, String name, String AuthorName){

}
