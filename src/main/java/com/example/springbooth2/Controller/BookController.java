package com.example.springbooth2.Controller;


import com.example.springbooth2.Dto.Book.BookRequestDto;
import com.example.springbooth2.Dto.Book.BookResponseDto;
import com.example.springbooth2.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;


    public BookController(BookService service){
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<BookResponseDto> create(@RequestBody BookRequestDto obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<BookResponseDto> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findBookById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<BookResponseDto> update(@PathVariable Long id, @RequestBody BookRequestDto book){
        return ResponseEntity.ok().body(service.update(id, book));
    }

}
