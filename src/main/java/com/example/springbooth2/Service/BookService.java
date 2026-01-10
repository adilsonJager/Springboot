package com.example.springbooth2.Service;


import com.example.springbooth2.Dto.BookCreatDto;
import com.example.springbooth2.Dto.BookSimplesDto;
import com.example.springbooth2.Dto.BookWithAuthorNameDto;
import com.example.springbooth2.Entity.AuthorEntity;
import com.example.springbooth2.Entity.BookEntity;
import com.example.springbooth2.Respository.AuthorRepository;
import com.example.springbooth2.Respository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorRepository authorRepository;


    public BookWithAuthorNameDto create (BookCreatDto dto){

        AuthorEntity author;

        if (dto.getAuthorId() != null){
            author = authorRepository.findById(dto.getAuthorId())
                    .orElseThrow(() -> new EntityNotFoundException("Author not find"));
        } else {
            author = authorRepository.findById(1L).orElseThrow();
        }

        BookEntity book = new BookEntity();
        book.setName(dto.getName());
        book.setAuthor(author);

        book = repository.save(book);

        return new BookWithAuthorNameDto(
                book.getId(),
                book.getName(),
                author.getName()
        );

    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public BookEntity findBookById(Long id){
        Optional<BookEntity> obj = repository.findById(id);
        return obj.get();
    }

    public List<BookEntity> getAll(){
        return repository.findAll();
    }

    public BookEntity update(BookEntity obj){
        Optional<BookEntity> newObj = repository.findById(obj.getId());
        updateBook(newObj, obj);
        repository.save(newObj.get());
        return newObj.get();

    }

    private void updateBook(Optional<BookEntity> newObj, BookEntity obj) {
        newObj.get().setName(obj.getName());
    }

}
