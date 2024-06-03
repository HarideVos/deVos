package com.binary.library.advices;

import com.binary.library.exceptions.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LibraryExceptionHandler extends RuntimeException{
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {BookNotFoundException.class})
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException carNotFoundException){
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Message ", carNotFoundException.getMessage());
        errorMap.put("TimeStamp ", new Date().toString());
        errorMap.put("httpStatus ", HttpStatus.NOT_FOUND.toString());

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handelMethodArgumentNotValidException(MethodArgumentNotValidException validException){
        Map<String, String> errorMap = new HashMap<>();

        validException.getFieldErrors().forEach(error ->{
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        errorMap.put("TimeStamp ", new Date().toString());
        errorMap.put("httpStatus ", HttpStatus.BAD_REQUEST.toString());

        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {NoResourceFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> noResourceFoundException(NoResourceFoundException noResourceFoundException){
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("Message ", noResourceFoundException.getMessage());
        errorMap.put("TimeStamp ", new Date().toString());
        errorMap.put("httpStatus ", HttpStatus.NOT_FOUND.getReasonPhrase());
        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }

}
