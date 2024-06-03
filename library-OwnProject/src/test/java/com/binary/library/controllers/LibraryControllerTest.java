package com.binary.library.controllers;

import com.binary.library.dtos.LibraryDto;
import com.binary.library.entities.Library;
import com.binary.library.exceptions.BookNotFoundException;
import com.binary.library.services.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LibraryControllerTest {

    @Mock
    private LibraryService libraryService;

    @InjectMocks
    private LibraryController libraryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllBooks() {
        List<Library> books = new ArrayList<>();
        books.add(new Library());
        books.add(new Library());
        when(libraryService.getAllBooks()).thenReturn(books);

        ResponseEntity<List<Library>> response = libraryController.getAllBooks();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(libraryService, times(1)).getAllBooks();
    }

    @Test
    void testCreateBook() {
        LibraryDto bookDto = new LibraryDto(1, "Lord of the Rings", "Tolkien");
        Library createdBook = new Library();
        when(libraryService.createBook(bookDto)).thenReturn(createdBook);

        ResponseEntity<Library> response = libraryController.createBook(bookDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdBook, response.getBody());
        verify(libraryService, times(1)).createBook(bookDto);
    }

    @Test
    void testUpdateBook() {
        long id = 1L;
        LibraryDto bookDto = new LibraryDto(1, "Lord of the Rings", "Tolkien");
        Library updatedBook = new Library();
        when(libraryService.updateBook(id, bookDto)).thenReturn(updatedBook);

        ResponseEntity<Library> response = libraryController.updateBook(id, bookDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedBook, response.getBody());
        verify(libraryService, times(1)).updateBook(id, bookDto);
    }

    @Test
    void testDeleteBook() {
        long id = 1L;
        doNothing().when(libraryService).deleteBook(id);

        ResponseEntity<Void> response = libraryController.deleteBook(id);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(libraryService, times(1)).deleteBook(id);
    }

    @Test
    void testGetBookById() {
        long id = 1L;
        Library book = new Library();
        when(libraryService.getBookById(id)).thenReturn(book);

        ResponseEntity<Library> response = libraryController.getBookById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
        verify(libraryService, times(1)).getBookById(id);
    }

    @Test
    void testGetBookByIdNotFound() {
        long id = 1L;
        when(libraryService.getBookById(id)).thenThrow(new BookNotFoundException("Book not found"));

        ResponseEntity<Library> response = libraryController.getBookById(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(libraryService, times(1)).getBookById(id);
    }
}
