package com.example.springbooth2.Controller;


import com.example.springbooth2.Dto.AuthorWithListOfBooksDto;
import com.example.springbooth2.Entity.AuthorEntity;
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
    public ResponseEntity<AuthorEntity> creat(@RequestBody AuthorEntity author){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(author));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AuthorWithListOfBooksDto> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findAuthorById(id));
    }

    @GetMapping
    public ResponseEntity<List<AuthorEntity>> getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<AuthorEntity> update(@PathVariable Long id, @RequestBody AuthorEntity author){
        author.setId(id);
        return ResponseEntity.ok().body(service.update(author));
    }


}
