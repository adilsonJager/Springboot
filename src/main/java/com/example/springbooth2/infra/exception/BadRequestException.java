package com.example.springbooth2.infra.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException  extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }

    public static BadRequestException authorIdNotNull (){
        return new BadRequestException("The given author must not be null");
    }

    public static BadRequestException authorCanBeDelet (String id){
        return new BadRequestException("The author: " + id + " has books associated and can't be deleted.");
    }

}
