package com.example.springbooth2.domain.author.controller;


import com.example.springbooth2.domain.author.dto.request.AuthorCreateRequestDto;
import com.example.springbooth2.domain.author.dto.response.AuthorResponseDto;
import com.example.springbooth2.domain.author.dto.request.AuthorUpdateRequestDto;
import com.example.springbooth2.domain.author.dto.response.AuthorwithlistResponseDto;
import com.example.springbooth2.domain.author.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {


    private final AuthorService service;

    public AuthorController(AuthorService authorService){
        this.service = authorService;
    }


    @PostMapping
    public ResponseEntity<AuthorResponseDto> register(@RequestBody @Valid AuthorCreateRequestDto author){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.register(author));
    }

    @GetMapping
    public ResponseEntity<List<AuthorwithlistResponseDto>> getAll(){
        return ResponseEntity.ok().body(this.service.getAll());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AuthorwithlistResponseDto> getId(@PathVariable @Valid String id){
        return ResponseEntity.ok().body(this.service.findAuthorById(id));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable @Valid String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<AuthorResponseDto> update(@PathVariable @Valid String id, @RequestBody @Valid AuthorUpdateRequestDto author){
        return ResponseEntity.ok().body(this.service.update(id, author));
    }


}
