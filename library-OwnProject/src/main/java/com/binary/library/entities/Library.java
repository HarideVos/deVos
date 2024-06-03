package com.binary.library.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;
    private String publishedName;
    private String authorName;
    private Integer ISBN;
    private double timeBorrow;
    private boolean borrowed; // Indicates whether the book is currently borrowed or not

    // Constructors
    public Library() {
    }

    public Library(String bookName, String publishedName, String authorName, Integer ISBN, double timeBorrow) {
        this.bookName = bookName;
        this.publishedName = publishedName;
        this.authorName = authorName;
        this.ISBN = ISBN;
        this.timeBorrow = timeBorrow;
    }

    public Library(long l, String title, String author) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublishedName() {
        return publishedName;
    }

    public void setPublishedName(String publishedName) {
        this.publishedName = publishedName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public double getTimeBorrow() {
        return timeBorrow;
    }

    public void setTimeBorrow(double timeBorrow) {
        this.timeBorrow = timeBorrow;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}