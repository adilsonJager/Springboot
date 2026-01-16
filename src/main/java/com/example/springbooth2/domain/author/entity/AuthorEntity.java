package com.example.springbooth2.domain.author.entity;

import com.example.springbooth2.domain.book.entity.BookEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "tb_author")
@Entity(name = "author")
public class AuthorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;
    private String password;

    //UM AUTOR PARA MUITOS LIVROS
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<BookEntity> books = new ArrayList<>();

    public AuthorEntity(String name) {
        this.name = name;
    }

    public AuthorEntity(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
