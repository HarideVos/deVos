package com.library.library.exceptions;

public class BooksNotFoundException extends RuntimeException{
    public BooksNotFoundException(String message) {
        super(message);
    }

    public BooksNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
