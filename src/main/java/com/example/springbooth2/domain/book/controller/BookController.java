package com.example.springbooth2.domain.book.controller;


import com.example.springbooth2.domain.book.dto.request.BookRequestDto;
import com.example.springbooth2.domain.book.dto.response.BookResponseDto;
import com.example.springbooth2.domain.book.service.BookService;
import jakarta.validation.Valid;
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

    @PostMapping(value = "/register")
    public ResponseEntity<BookResponseDto> register(@RequestBody @Valid BookRequestDto obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.register(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<BookResponseDto> getId(@PathVariable @Valid String id){
        return ResponseEntity.ok().body(this.service.findBookById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAll(){
        return ResponseEntity.ok().body(this.service.getAll());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<BookResponseDto> update(@PathVariable @Valid String id, @RequestBody @Valid BookRequestDto book){
        return ResponseEntity.ok().body(this.service.update(id, book));
    }

}
