package com.example.springbooth2.domain.book.entity;

import com.example.springbooth2.domain.author.entity.AuthorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Entity(name = "book")
@Table(name="tb_Book")
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    //MUITOS LIVROS PARA UM AUTOR
    @ManyToOne
    @JoinColumn(name = "author_id") // ALTERA NOME DA COLUNA
    private AuthorEntity author;


    public BookEntity(String name, AuthorEntity author) {
        this.name = name;
        this.author = author;
    }
}
