package com.binary.library.repositories;

import com.binary.library.entities.Library;
import com.binary.library.entities.Visitor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class RepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private VisitorRepository visitorRepository;

    @Test
    void testLibraryRepository() {
        // Create a test library entity
        Library library = new Library("Book Name", "Published Name", "Author Name", 1234567890, 7.5);

        // Save the library entity to the repository
        Library savedLibrary = libraryRepository.save(library);

        // Retrieve the saved library entity by ID
        Library retrievedLibrary = libraryRepository.findById(savedLibrary.getId()).orElse(null);

        // Check if the retrieved library entity is not null and its attributes match the saved entity
        assertNotNull(retrievedLibrary);
        assertEquals(savedLibrary.getId(), retrievedLibrary.getId());
        assertEquals(savedLibrary.getBookName(), retrievedLibrary.getBookName());
        assertEquals(savedLibrary.getPublishedName(), retrievedLibrary.getPublishedName());
        assertEquals(savedLibrary.getAuthorName(), retrievedLibrary.getAuthorName());
        assertEquals(savedLibrary.getISBN(), retrievedLibrary.getISBN());
        assertEquals(savedLibrary.getTimeBorrow(), retrievedLibrary.getTimeBorrow());
        assertEquals(savedLibrary.isBorrowed(), retrievedLibrary.isBorrowed());
    }

    @Test
    void testVisitorRepository() {
        // Create a test visitor entity
        Visitor visitor = new Visitor("John Doe", "john@example.com", "password", "ROLE_USER");

        // Save the visitor entity to the repository
        Visitor savedVisitor = visitorRepository.save(visitor);

        // Retrieve the saved visitor entity by email
        Visitor retrievedVisitor = visitorRepository.findByEmail(savedVisitor.getEmail());

        // Check if the retrieved visitor entity is not null and its attributes match the saved entity
        assertNotNull(retrievedVisitor);
        assertEquals(savedVisitor.getId(), retrievedVisitor.getId());
        assertEquals(savedVisitor.getName(), retrievedVisitor.getName());
        assertEquals(savedVisitor.getEmail(), retrievedVisitor.getEmail());
        assertEquals(savedVisitor.getPassword(), retrievedVisitor.getPassword());
        assertEquals(savedVisitor.getRole(), retrievedVisitor.getRole());
    }
}
