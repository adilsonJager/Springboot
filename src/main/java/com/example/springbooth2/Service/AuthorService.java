package com.example.springbooth2.Service;

import com.example.springbooth2.Dto.Author.AuthorCreateDto;
import com.example.springbooth2.Dto.Author.AuthorResponseDto;
import com.example.springbooth2.Dto.Author.AuthorUpdateRequestDto;
import com.example.springbooth2.Dto.Author.AuthorwithlistResponseDto;
import com.example.springbooth2.Dto.Book.BookSimplesDto;
import com.example.springbooth2.Entity.AuthorEntity;
import com.example.springbooth2.Respository.AuthorRepository;
import com.example.springbooth2.Service.exception.BadRequestException;
import com.example.springbooth2.Service.exception.EntityNotFound;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {



    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository){
        this.repository = repository;
    }


    public AuthorCreateDto create (AuthorCreateDto dto){

        AuthorEntity author = new AuthorEntity(null, dto.getName());
        author = repository.save(author);
        return  new AuthorCreateDto(author.getId(), author.getName());

    }

    public void delete(Long id) {
        AuthorEntity author = repository.findById(id).orElseThrow(() -> EntityNotFound.authorNotFound(id));
        if (!author.getBooks().isEmpty()){
            throw BadRequestException.authorCanBeDelet(id);
        }
        repository.deleteById(author.getId());
    }

    public AuthorwithlistResponseDto findAuthorById(Long id){

        AuthorEntity author = repository.findById(id).orElseThrow(() -> EntityNotFound.authorNotFound(id));
        AuthorwithlistResponseDto dto = new AuthorwithlistResponseDto(author.getId(), author.getName(), mapEntity(author));
        return dto;
    }

    public List<AuthorwithlistResponseDto> getAll(){

        List<AuthorEntity> authors = repository.findAll();

        return authors.stream()
                .map(this::fillUpAuthorResponse).toList();

    }

    public AuthorResponseDto update(Long id, AuthorUpdateRequestDto dto){

        AuthorEntity author = repository.findById(id)
                .orElseThrow(() -> EntityNotFound.authorNotFound(id));

        author.setName(dto.getName());
        AuthorEntity saved = repository.save(author);

        return new AuthorResponseDto(saved.getId(), saved.getName());

    }

    private List<BookSimplesDto> mapEntity(AuthorEntity books){


        return books.getBooks().stream()
        .map(b -> new BookSimplesDto(
                b.getId(),
                b.getName()
        )).toList();

    }


    public AuthorwithlistResponseDto fillUpAuthorResponse (AuthorEntity entity){
        return new AuthorwithlistResponseDto(entity.getId(), entity.getName(), mapEntity(entity));
    }

}
