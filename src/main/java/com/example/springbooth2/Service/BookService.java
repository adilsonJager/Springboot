package com.example.springbooth2.Service;


import com.example.springbooth2.Dto.Book.BookRequestDto;
import com.example.springbooth2.Dto.Book.BookResponseDto;
import com.example.springbooth2.Entity.AuthorEntity;
import com.example.springbooth2.Entity.BookEntity;
import com.example.springbooth2.Respository.AuthorRepository;
import com.example.springbooth2.Respository.BookRepository;
import com.example.springbooth2.Service.exception.BadRequestException;
import com.example.springbooth2.Service.exception.EntityNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {


    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorRepository authorRepository;


    public BookResponseDto create (BookRequestDto dto){

        if (dto.getAuthorId() == null){
            throw BadRequestException.authorIdNotNull();
        }

        AuthorEntity author = authorRepository.findById(dto.getAuthorId())
                    .orElseThrow(() -> EntityNotFound.authorNotFound(dto.getAuthorId()));


        BookEntity book = new BookEntity();
        book.setName(dto.getName());
        book.setAuthor(author);
        book = repository.save(book);

        return new BookResponseDto(
                book.getId(),
                book.getName(),
                book.getAuthor().getName()
        );

    }

    public void delete(Long id){
        BookEntity book = repository.findById(id).orElseThrow( () -> EntityNotFound.bookNotFound(id));
        repository.deleteById(book.getId());
    }

    public BookResponseDto findBookById(Long id){
        BookEntity book = repository.findById(id).orElseThrow(() -> EntityNotFound.bookNotFound(id));
        return new BookResponseDto(
                book.getId(),
                book.getName(),
                book.getAuthor().getName()
        );
    }

    public List<BookResponseDto> getAll(){
            List<BookEntity> books = repository.findAll();

            return books.stream()
                    .map(book -> {

                        return new BookResponseDto(
                                book.getId(),
                                book.getName(),
                                book.getAuthor().getName()
                        );
                    }).toList();
    }

    public BookResponseDto update(Long id, BookRequestDto obj){

        if (obj.getAuthorId() == null ){throw  BadRequestException.authorIdNotNull();}
        AuthorEntity author = authorRepository.findById(obj.getAuthorId()).orElseThrow(() -> EntityNotFound.authorNotFound(obj.getAuthorId()));
        BookEntity newObj = repository.findById(id).orElseThrow(() -> EntityNotFound.bookNotFound(id));

        newObj.setName(obj.getName());
        newObj.setAuthor(author);

        repository.save(newObj);

        return new BookResponseDto(
                newObj.getId(),
                newObj.getName(),
                newObj.getAuthor().getName()
        );


    }

}
