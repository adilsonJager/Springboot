package com.example.springbooth2.Service;

import com.example.springbooth2.Dto.Author.AuthorCreateDto;
import com.example.springbooth2.Dto.Author.AuthorResponseDto;
import com.example.springbooth2.Dto.Author.AuthorUpdateRequestDto;
import com.example.springbooth2.Dto.Author.AuthorWithListOfBooksDto;
import com.example.springbooth2.Dto.Book.BookSimplesDto;
import com.example.springbooth2.Entity.AuthorEntity;
import com.example.springbooth2.Respository.AuthorRepository;
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
        AuthorEntity idAuthor = repository.findById(id).orElseThrow(() -> EntityNotFound.authorNotFound(id));
        repository.deleteById(idAuthor.getId());
    }

    public AuthorWithListOfBooksDto findAuthorById(Long id){

        AuthorEntity author = repository.findById(id).orElseThrow(() -> EntityNotFound.authorNotFound(id));
        AuthorWithListOfBooksDto dto = new AuthorWithListOfBooksDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setBooks(mapEntity(author));
        return dto;
    }

    public List<AuthorWithListOfBooksDto> getAll(){

        List<AuthorEntity> authors = repository.findAll();

        return authors.stream()
                .map(author -> {
                    AuthorWithListOfBooksDto dto = new AuthorWithListOfBooksDto();
                    dto.setId(author.getId());
                    dto.setName(author.getName());

                    dto.setBooks(mapEntity(author));
                    return dto;
                }).toList();

    }

    public AuthorResponseDto update(Long id, AuthorUpdateRequestDto dto){

        AuthorEntity author = repository.findById(id)
                .orElseThrow(() -> EntityNotFound.authorNotFound(id));

        author.setName(dto.getName());
        AuthorEntity saved = repository.save(author);

        return new AuthorResponseDto(saved.getId(), saved.getName());

    }



    private List<BookSimplesDto> mapEntity(AuthorEntity books){

                List<BookSimplesDto> newList = books.getBooks().stream()
                .map(b -> new BookSimplesDto(
                        b.getId(),
                        b.getName()
                )).toList();

                return newList;

    }



}
