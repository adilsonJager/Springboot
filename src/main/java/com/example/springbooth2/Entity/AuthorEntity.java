package com.example.springbooth2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_author")
public class AuthorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //UM AUTOR PARA MUITOS LIVROS
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<BookEntity> books = new ArrayList<>();


    public AuthorEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AuthorEntity() {
    }

    public AuthorEntity(String name) {
        this.name = name;
    }
}
