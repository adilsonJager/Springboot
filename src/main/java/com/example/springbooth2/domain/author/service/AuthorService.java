package com.example.springbooth2.domain.author.service;

import com.example.springbooth2.domain.author.dto.request.AuthorCreateRequestDto;
import com.example.springbooth2.domain.author.dto.response.AuthorResponseDto;
import com.example.springbooth2.domain.author.dto.request.AuthorUpdateRequestDto;
import com.example.springbooth2.domain.author.dto.response.AuthorwithlistResponseDto;
import com.example.springbooth2.domain.book.dto.response.BookSimplesResponseDto;
import com.example.springbooth2.domain.author.entity.AuthorEntity;
import com.example.springbooth2.domain.author.repository.AuthorRepository;
import com.example.springbooth2.infra.exception.BadRequestException;
import com.example.springbooth2.infra.exception.EntityNotFound;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository repository;
    public AuthorService(AuthorRepository repository){
        this.repository = repository;
    }


    public AuthorResponseDto register(AuthorCreateRequestDto dto){

        AuthorEntity author = new AuthorEntity(dto.name(), dto.email(), dto.password());
        author = this.repository.save(author);
        return  new AuthorResponseDto(author.getId(), author.getName());

    }

    public void delete(String id) {
        AuthorEntity author = this.repository.findById(id).orElseThrow(() -> EntityNotFound.authorNotFound(id));
        if (!author.getBooks().isEmpty()){
            throw BadRequestException.authorCanBeDelet(id);
        }
        this.repository.deleteById(author.getId());
    }

    public AuthorwithlistResponseDto findAuthorById(String id){

        AuthorEntity author = this.repository.findById(id).orElseThrow(() -> EntityNotFound.authorNotFound(id));
        AuthorwithlistResponseDto dto = new AuthorwithlistResponseDto(author.getId(), author.getName(), mapEntity(author));
        return dto;
    }

    public List<AuthorwithlistResponseDto> getAll(){

        List<AuthorEntity> authors = this.repository.findAll();

        return authors.stream()
                .map(this::AuthorMap).toList();
    }

    public AuthorResponseDto update(String id, AuthorUpdateRequestDto dto){

        AuthorEntity author = this.repository.findById(id)
                .orElseThrow(() -> EntityNotFound.authorNotFound(id));

        author.setName(dto.name());
        AuthorEntity saved = this.repository.save(author);

        return new AuthorResponseDto(saved.getId(), saved.getName());

    }

    private List<BookSimplesResponseDto> mapEntity(AuthorEntity books){
        return books.getBooks().stream()
        .map(b -> new BookSimplesResponseDto(
                b.getId(),
                b.getName()
        )).toList();
    }


    public AuthorwithlistResponseDto AuthorMap(AuthorEntity entity){
        return new AuthorwithlistResponseDto(entity.getId(), entity.getName(), mapEntity(entity));
    }

}
