package com.binary.library.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryDtoTest {

    @Test
    void testNoArgsConstructor() {
        LibraryDto dto = new LibraryDto(1, "Lord of the Rings", "Tolkien");
        assertNull(dto.getTitle());
        assertNull(dto.getAuthor());
    }

    @Test
    void testAllArgsConstructor() {
        String title = "Title";
        String author = "Author";
        LibraryDto dto = new LibraryDto(1L, title, author);
        assertEquals(title, dto.getTitle());
        assertEquals(author, dto.getAuthor());
    }

    @Test
    void testSetTitle() {
        LibraryDto dto = new LibraryDto(1, "Lord of the Rings", "Tolkien");
        String title = "New Title";
        dto.setTitle(title);
        assertEquals(title, dto.getTitle());
    }

    @Test
    void testSetAuthor() {
        LibraryDto dto = new LibraryDto(1, "Lord of the Rings", "Tolkien");
        String author = "New Author";
        dto.setAuthor(author);
        assertEquals(author, dto.getAuthor());
    }
}

