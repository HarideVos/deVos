package com.library.library.dtos;

import lombok.Data;

@Data
public class LibraryDto {
    private String bookName;
    private String publishedName;
    private String authorName;
    private Integer ISBN;
    private double timeBorrow;

    // Getters and setters
}