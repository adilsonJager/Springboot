package com.example.springbooth2.Controller;


import com.example.springbooth2.Dto.Author.AuthorCreateDto;
import com.example.springbooth2.Dto.Author.AuthorResponseDto;
import com.example.springbooth2.Dto.Author.AuthorUpdateRequestDto;
import com.example.springbooth2.Dto.Author.AuthorwithlistResponseDto;
import com.example.springbooth2.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {


    @Autowired
    private AuthorService service;

    @PostMapping
    public ResponseEntity<AuthorCreateDto> creat(@RequestBody AuthorCreateDto author){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(author));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AuthorwithlistResponseDto> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findAuthorById(id));
    }

    @GetMapping
    public ResponseEntity<List<AuthorwithlistResponseDto>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<AuthorResponseDto> update(@PathVariable Long id, @RequestBody AuthorUpdateRequestDto author){
        return ResponseEntity.ok().body(service.update(id, author));
    }


}
