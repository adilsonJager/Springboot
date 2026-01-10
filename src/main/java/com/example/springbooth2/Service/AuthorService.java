package com.example.springbooth2.Service;

import com.example.springbooth2.Entity.AuthorEntity;
import com.example.springbooth2.Respository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {


    @Autowired
    private AuthorRepository repository;


    public AuthorEntity create (AuthorEntity author){
        return repository.save(author);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public AuthorEntity findAuthorById(Long id){
        Optional<AuthorEntity> author = repository.findById(id);
        return author.get();
    }

    public List<AuthorEntity> getAll(){return repository.findAll();}

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
