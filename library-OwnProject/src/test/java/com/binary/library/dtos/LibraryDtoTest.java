package com.binary.library.dtos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryDtoTest {

    @Test
    void testNoArgsConstructor() {
        LibraryDto dto = new LibraryDto();
        assertNull(dto.getTitle());
        assertNull(dto.getAuthor());
    }

    @Test
    void testAllArgsConstructor() {
        LibraryDto dto = new LibraryDto();
        String title = "title";
        String author = "author";
        dto.setAuthor(author);
        dto.setTitle(title);
        assertEquals(title, dto.getTitle());
        assertEquals(author, dto.getAuthor());
    }

    @Test
    void testSetTitle() {
        LibraryDto dto = new LibraryDto();
        String title = "New Title";
        dto.setTitle(title);
        assertEquals(title, dto.getTitle());
    }

    @Test
    void testSetAuthor() {
        LibraryDto dto = new LibraryDto();
        String author = "New Author";
        dto.setAuthor(author);
        assertEquals(author, dto.getAuthor());
    }
}

