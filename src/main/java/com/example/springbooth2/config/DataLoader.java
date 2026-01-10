package com.example.springbooth2.config;


import com.example.springbooth2.Entity.AuthorEntity;
import com.example.springbooth2.Respository.AuthorRepository;
import com.example.springbooth2.Respository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(AuthorRepository authorRepository) {
        return args -> {
            List<AuthorEntity> authors = List.of(
                    new AuthorEntity("unknown"),
                    new AuthorEntity("Patrick Rothfuss"),
                    new AuthorEntity("J. R. R. Tolkien"),
                    new AuthorEntity("George R. R. Martin"),
                    new AuthorEntity("Brandon Sanderson"),
                    new AuthorEntity("Isaac Asimov"),
                    new AuthorEntity("Frank Herbert"),
                    new AuthorEntity("Ursula K. Le Guin"),
                    new AuthorEntity("Philip K. Dick"),
                    new AuthorEntity("Arthur C. Clarke"),
                    new AuthorEntity("C. S. Lewis"),

                    new AuthorEntity("Stephen King"),
                    new AuthorEntity("Neil Gaiman"),
                    new AuthorEntity("Terry Pratchett"),
                    new AuthorEntity("H. P. Lovecraft"),
                    new AuthorEntity("Ray Bradbury"),
                    new AuthorEntity("Aldous Huxley"),
                    new AuthorEntity("George Orwell"),
                    new AuthorEntity("Mary Shelley"),
                    new AuthorEntity("Bram Stoker"),
                    new AuthorEntity("Jules Verne"),

                    new AuthorEntity("H. G. Wells"),
                    new AuthorEntity("Agatha Christie"),
                    new AuthorEntity("J. K. Rowling"),
                    new AuthorEntity("Dan Brown"),
                    new AuthorEntity("Paulo Coelho"),
                    new AuthorEntity("Machado de Assis"),
                    new AuthorEntity("Clarice Lispector"),
                    new AuthorEntity("José Saramago"),
                    new AuthorEntity("Umberto Eco"),
                    new AuthorEntity("Gabriel García Márquez")
            );

            authorRepository.saveAll(authors);
        };
    }

}
