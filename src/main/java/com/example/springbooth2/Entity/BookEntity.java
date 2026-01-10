package com.example.springbooth2.Entity;

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
@Entity
@Table(name="tb_Book")
public class BookEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //MUITOS LIVROS PARA UM AUTOR
    @ManyToOne
    @JoinColumn(name = "author_id") // ALTERA NOME DA COLUNA
    private AuthorEntity author;


    public BookEntity(String name) {
    }
}
