package com.example.springbooth2.Dto.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class BookResponseDto {

    private Long id;
    private String name;
    private String AuthorName;

}
