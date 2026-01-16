package com.example.springbooth2.domain.book.service;

import com.example.springbooth2.domain.book.dto.request.BookRequestDto;
import com.example.springbooth2.domain.book.dto.response.BookResponseDto;
import com.example.springbooth2.domain.author.entity.AuthorEntity;
import com.example.springbooth2.domain.book.entity.BookEntity;
import com.example.springbooth2.domain.author.repository.AuthorRepository;
import com.example.springbooth2.domain.book.repository.BookRepository;
import com.example.springbooth2.infra.exception.BadRequestException;
import com.example.springbooth2.infra.exception.EntityNotFound;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class BookService {

    private final BookRepository repository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository repository, AuthorRepository authorRepository){

        this.repository = repository;
        this.authorRepository = authorRepository;

    }


    public BookResponseDto register(BookRequestDto dto){

        if (dto.authorId().isBlank()) throw BadRequestException.authorIdNotNull();

        AuthorEntity author = this.authorRepository.findById(dto.authorId())
                    .orElseThrow(() -> EntityNotFound.authorNotFound(dto.authorId()));


        BookEntity book = new BookEntity(
                dto.name(),
                author
        );

        book = repository.save(book);
        return BookMapper(book);

    }

    public void delete(String id){
        BookEntity book = this.repository.findById(id)
                .orElseThrow( () -> EntityNotFound.bookNotFound(id));
        this.repository.delete(book);
    }

    public BookResponseDto findBookById(String id){
        BookEntity book = this.repository.findById(id)
                .orElseThrow(() -> EntityNotFound.bookNotFound(id));
        return BookMapper(book);
    }

    public List<BookResponseDto> getAll(){
            List<BookEntity> books = this.repository.findAll();

            return books.stream()
                    .map(this::BookMapper).toList();
    }

    public BookResponseDto update(String id, BookRequestDto obj){

        if (obj.authorId() == null ){throw  BadRequestException.authorIdNotNull();}
        AuthorEntity author = this.authorRepository.findById(obj.authorId()).orElseThrow(() -> EntityNotFound.authorNotFound(obj.authorId()));
        BookEntity newObj = this.repository.findById(id).orElseThrow(() -> EntityNotFound.bookNotFound(id));

        newObj.setName(obj.name());
        newObj.setAuthor(author);

        repository.save(newObj);

        return BookMapper(newObj);


    }

    public BookResponseDto BookMapper(BookEntity book){
        return new BookResponseDto(book.getId(), book.getName(), book.getAuthor().getName());
    }

}
