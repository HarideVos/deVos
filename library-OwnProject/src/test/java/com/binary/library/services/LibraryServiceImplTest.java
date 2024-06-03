package com.binary.library.services;

import com.binary.library.dtos.LibraryDto;
import com.binary.library.entities.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceImplTest {

    private LibraryService libraryService;

    @BeforeEach
    void setUp() {
        libraryService = new LibraryServiceImpl();
    }

    @Test
    void testCreateBook() {
        LibraryDto bookDto = new LibraryDto(1,"Published Name", "Author Name");
        Library createdBook = libraryService.createBook(bookDto);

        assertNotNull(createdBook);
        assertEquals("Book Title", createdBook.getBookName());
        assertEquals("Published Name", createdBook.getPublishedName());
        assertEquals("Author Name", createdBook.getAuthorName());

    }

    @Test
    void testUpdateBook() {
        // Add a book
        LibraryDto bookDto = new LibraryDto(1, "Published Name", "Author Name");
        Library createdBook = libraryService.createBook(bookDto);

        // Update the book
        LibraryDto updatedBookDto = new LibraryDto(1,"Updated Published Name", "Updated Author Name");
        Library updatedBook = libraryService.updateBook(createdBook.getId(), updatedBookDto);

        assertNotNull(updatedBook);
        assertEquals("Updated Book Title", updatedBook.getBookName());
        assertEquals("Updated Published Name", updatedBook.getPublishedName());
        assertEquals("Updated Author Name", updatedBook.getAuthorName());

    }

    @Test
    void testGetAllBooks() {
        // Add some books
        LibraryDto bookDto1 = new LibraryDto(1, "Published Name 1", "Author Name 1");
        LibraryDto bookDto2 = new LibraryDto(2, "Published Name 2", "Author Name 2");
        libraryService.createBook(bookDto1);
        libraryService.createBook(bookDto2);

        List<Library> allBooks = libraryService.getAllBooks();

        assertEquals(2, allBooks.size());
    }

    @Test
    void testDeleteBook() {
        // Add a book
        LibraryDto bookDto = new LibraryDto(1, "Published Name", "Author Name");
        Library createdBook = libraryService.createBook(bookDto);

        // Delete the book
        Long deletedBookId = libraryService.deleteBook(createdBook.getId());

        assertNotNull(deletedBookId);
        assertEquals(createdBook.getId(), deletedBookId);
    }

    @Test
    void testGetBookById() {
        // Add a book
        LibraryDto bookDto = new LibraryDto(1, "Published Name", "Author Name");
        Library createdBook = libraryService.createBook(bookDto);

        // Retrieve the book by ID
        Library retrievedBook = libraryService.getBookById(createdBook.getId());

        assertNotNull(retrievedBook);
        assertEquals(createdBook.getId(), retrievedBook.getId());
        assertEquals(createdBook.getBookName(), retrievedBook.getBookName());
        assertEquals(createdBook.getPublishedName(), retrievedBook.getPublishedName());
        assertEquals(createdBook.getAuthorName(), retrievedBook.getAuthorName());
        assertEquals(createdBook.getISBN(), retrievedBook.getISBN());
        assertEquals(createdBook.getTimeBorrow(), retrievedBook.getTimeBorrow());
    }
}
