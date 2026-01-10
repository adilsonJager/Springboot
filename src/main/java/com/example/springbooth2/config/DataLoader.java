package com.example.springbooth2.config;


import com.example.springbooth2.Entity.AuthorEntity;
import com.example.springbooth2.Entity.BookEntity;
import com.example.springbooth2.Respository.AuthorRepository;
import com.example.springbooth2.Respository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class DataLoader implements CommandLineRunner{


    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public DataLoader(BookRepository bookRepository, AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;}

    @Override
    public void run(String... args) throws Exception {
        AuthorEntity a1  = new AuthorEntity(null, "J. R. R. Tolkien");
        AuthorEntity a2  = new AuthorEntity(null, "George Orwell");
        AuthorEntity a3  = new AuthorEntity(null, "Stephen King");
        AuthorEntity a4  = new AuthorEntity(null, "Agatha Christie");
        AuthorEntity a5  = new AuthorEntity(null, "Machado de Assis");
        AuthorEntity a6  = new AuthorEntity(null, "J. K. Rowling");
        AuthorEntity a7  = new AuthorEntity(null, "Isaac Asimov");
        AuthorEntity a8  = new AuthorEntity(null, "George R. R. Martin");
        AuthorEntity a9  = new AuthorEntity(null, "Dan Brown");
        AuthorEntity a10 = new AuthorEntity(null, "Fyodor Dostoevsky");
        AuthorEntity a11 = new AuthorEntity(null, "Franz Kafka");
        AuthorEntity a12 = new AuthorEntity(null, "Albert Camus");

        authorRepository.saveAll(Arrays.asList(
                a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12
        ));

        BookEntity l1  = new BookEntity(null, "The Fellowship of the Ring", a1);
        BookEntity l2  = new BookEntity(null, "The Two Towers", a1);
        BookEntity l3  = new BookEntity(null, "The Return of the King", a1);

        BookEntity l4  = new BookEntity(null, "1984", a2);
        BookEntity l5  = new BookEntity(null, "Animal Farm", a2);

        BookEntity l6  = new BookEntity(null, "The Shining", a3);
        BookEntity l7  = new BookEntity(null, "It", a3);
        BookEntity l8  = new BookEntity(null, "Misery", a3);

        BookEntity l9  = new BookEntity(null, "Murder on the Orient Express", a4);
        BookEntity l10 = new BookEntity(null, "And Then There Were None", a4);

        BookEntity l11 = new BookEntity(null, "Dom Casmurro", a5);
        BookEntity l12 = new BookEntity(null, "Memórias Póstumas de Brás Cubas", a5);

        BookEntity l13 = new BookEntity(null, "Harry Potter and the Philosopher's Stone", a6);

        BookEntity l14 = new BookEntity(null, "Foundation", a7);
        BookEntity l15 = new BookEntity(null, "Foundation and Empire", a7);
        BookEntity l16 = new BookEntity(null, "Second Foundation", a7);

        BookEntity l17 = new BookEntity(null, "A Game of Thrones", a8);

        BookEntity l18 = new BookEntity(null, "The Da Vinci Code", a9);

        BookEntity l19 = new BookEntity(null, "Crime and Punishment", a10);
        BookEntity l20 = new BookEntity(null, "The Brothers Karamazov", a10);

        bookRepository.saveAll(Arrays.asList(
                l1, l2, l3, l4, l5, l6, l7, l8,
                l9, l10, l11, l12, l13, l14, l15,
                l16, l17, l18, l19, l20
        ));
    }
}




