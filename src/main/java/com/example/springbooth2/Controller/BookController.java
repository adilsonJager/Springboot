package com.example.springbooth2.Controller;


import com.example.springbooth2.Dto.BookCreatDto;
import com.example.springbooth2.Dto.BookWithAuthorNameDto;
import com.example.springbooth2.Entity.BookEntity;
import com.example.springbooth2.Service.BookService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {


    @Autowired
    private  BookService service;


    @PostMapping
    public ResponseEntity<BookWithAuthorNameDto> create(@RequestBody BookCreatDto obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<BookEntity> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findBookById(id));
    }

    @GetMapping
    public ResponseEntity<List<BookEntity>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<BookEntity> update(@PathVariable Long id, @RequestBody BookEntity book){
        book.setId(id);
        return ResponseEntity.ok().body(service.update(book));
    }

}
