package com.binary.library.services;

import com.binary.library.dtos.LibraryDto;
import com.binary.library.entities.Library;
import com.binary.library.exceptions.BookNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    private final List<Library> books = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Library> getAllBooks() {
        return books;
    }

    @Override
    public Library createBook(@Valid LibraryDto bookDto) {
        Library book = new Library(nextId++, bookDto.getTitle(), bookDto.getAuthor());
        books.add(book);
        return book;
    }

    @Override
    public Library updateBook(Long id, @Valid LibraryDto updatedBookDto) throws BookNotFoundException {
        for (int i = 0; i < books.size(); i++) {
            Library book = books.get(i);
            if (book.getId().equals(id)) {
                Library updatedBook = new Library(id, updatedBookDto.getTitle(), updatedBookDto.getAuthor());
                books.set(i, updatedBook);
                return updatedBook;
            }
        }
        throw new BookNotFoundException("Book not found with id: " + id);
    }

    @Override
    public Long deleteBook(Long id) throws BookNotFoundException {
        for (int i = 0; i < books.size(); i++) {
            Library book = books.get(i);
            if (book.getId().equals(id)) {
                books.remove(i);
                return id;
            }
        }
        throw new BookNotFoundException("Book not found with id: " + id);
    }

    @Override
    public Library getBookById(Long id) throws BookNotFoundException {
        for (Library book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found with id: " + id);
    }
}
