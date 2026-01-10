package com.example.springbooth2.Service;

import com.example.springbooth2.Dto.AuthorWithListOfBooksDto;
import com.example.springbooth2.Dto.BookSimplesDto;
import com.example.springbooth2.Entity.AuthorEntity;
import com.example.springbooth2.Respository.AuthorRepository;
import com.example.springbooth2.Respository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {


    @Autowired
    private AuthorRepository repository;
    @Autowired
    private BookRepository bookRepository;


    public AuthorEntity create (AuthorEntity author){
        return repository.save(author);
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
        List<BookSimplesDto> books = author.getBooks().stream().map(book -> new BookSimplesDto(
                book.getId(),
                book.getName()
        )).toList();
        dto.setBooks(books);
        return dto;

    }

    public List<AuthorEntity> getAll(){
        return repository.findAll();
    }

    public AuthorEntity update(AuthorEntity author){
        Optional<AuthorEntity> newAuthor = repository.findById(author.getId());
        updateAuthor(newAuthor, author);
        repository.save(newAuthor.get());
        return newAuthor.get();
    }

    private void updateAuthor(Optional<AuthorEntity> newAuthor, AuthorEntity author) {
        newAuthor.get().setName(author.getName());
    }


}
