package com.example.springbooth2.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFound extends RuntimeException{


    private EntityNotFound(String msg) {
        super(msg);
    }


    public static EntityNotFound authorNotFound(Long id) {
        return new EntityNotFound("Author de ID: " + id + " Não Encontrado");
    }

    public static EntityNotFound bookNotFound(Long id) {
        return new EntityNotFound("Livro de ID: " + id + " Não Encontrado");
    }

    }


