package com.binary.library.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void testNoArgsConstructor() {
        Library library = new Library();
        assertNull(library.getId());
        assertNull(library.getBookName());
        assertNull(library.getPublishedName());
        assertNull(library.getAuthorName());
        assertNull(library.getISBN());
        assertEquals(0.0, library.getTimeBorrow());
        assertFalse(library.isBorrowed());
    }

    @Test
    void testAllArgsConstructor() {
        Long id = 1L;
        String bookName = "Test Book";
        String publishedName = "Test Publisher";
        String authorName = "Test Author";
        Integer ISBN = 1234567890;
        double timeBorrow = 7.5;

        Library library = new Library(bookName, publishedName, authorName, ISBN, timeBorrow);

        assertEquals(id, library.getId());
        assertEquals(bookName, library.getBookName());
        assertEquals(publishedName, library.getPublishedName());
        assertEquals(authorName, library.getAuthorName());
        assertEquals(ISBN, library.getISBN());
        assertEquals(timeBorrow, library.getTimeBorrow());
        assertFalse(library.isBorrowed());
    }

    @Test
    void testSettersAndGetters() {
        Library library = new Library();

        Long id = 1L;
        String bookName = "Test Book";
        String publishedName = "Test Publisher";
        String authorName = "Test Author";
        Integer ISBN = 1234567890;
        double timeBorrow = 7.5;
        boolean borrowed = true;

        library.setId(id);
        library.setBookName(bookName);
        library.setPublishedName(publishedName);
        library.setAuthorName(authorName);
        library.setISBN(ISBN);
        library.setTimeBorrow(timeBorrow);
        library.setBorrowed(borrowed);

        assertEquals(id, library.getId());
        assertEquals(bookName, library.getBookName());
        assertEquals(publishedName, library.getPublishedName());
        assertEquals(authorName, library.getAuthorName());
        assertEquals(ISBN, library.getISBN());
        assertEquals(timeBorrow, library.getTimeBorrow());
        assertEquals(borrowed, library.isBorrowed());
    }
}
