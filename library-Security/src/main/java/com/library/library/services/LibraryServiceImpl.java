package com.library.library.services;

import com.library.library.dtos.LibraryDto;
import com.library.library.entities.Library;
import com.library.library.repositories.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public Library returnBooks(Library book) {
        return libraryRepository.save(book);
    }

    @Override
    public List<Library> getAllBooks() {
        return libraryRepository.findAll();
    }

    @Override
    public Library updateBooks(long id, Library book) {
        Library existingLibrary = libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Library with id " + id + " not found"));

        existingLibrary.setBookName(book.getBookName());
        existingLibrary.setPublishedName(book.getPublishedName());
        existingLibrary.setAuthorName(book.getAuthorName());
        existingLibrary.setISBN(book.getISBN());
        existingLibrary.setTimeBorrow(book.getTimeBorrow());

        return libraryRepository.save(existingLibrary);
    }

    @Override
    public Long borrowBooks(Long id) {
        Library book = libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Library with id " + id + " not found"));

        // Check if the book is available to borrow
        if (book.isBorrowed()) {
            // Update the book status to borrowed
            book.setBorrowed(true);
            // Implement additional logic such as updating the borrower's information, due dates, etc.
            libraryRepository.save(book);
            return id; // Returning the borrowed book's ID for demonstration
        } else {
            throw new RuntimeException("Library with id " + id + " is not available for borrowing");
        }
    }

    @Override
    public Library getBooksById(Long id) {
        return libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Library with id " + id + " not found"));
    }
}