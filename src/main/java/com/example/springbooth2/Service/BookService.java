package com.example.springbooth2.Service;


import com.example.springbooth2.Entity.BookEntity;
import com.example.springbooth2.Respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    @Autowired
    private BookRepository repository;

    // nao preciso do construtor por causa do @autoWired
//    public BookService(BookRepository bookRepository){
//        this.bookRepository = bookRepository;
//    }


    public BookEntity create (BookEntity obj){
         return repository.save(obj);
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
