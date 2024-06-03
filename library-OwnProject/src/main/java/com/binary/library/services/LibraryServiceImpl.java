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
    private long nextId = 1;

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
    public Library updateBook(long id, @Valid LibraryDto updatedBook) throws BookNotFoundException {
        for (int i = 0; i < books.size(); i++) {
            Library book = books.get(i);
            if (book.getId() == id) {
                updatedBook.setId((long) id);
                books.set(i, updatedBook);
                return updatedBook;
            }
        }
        throw new BookNotFoundException("Book not found with id: " + id);
    }

    @Override
    public Long deleteBook(long id) throws BookNotFoundException {
        for (int i = 0; i < books.size(); i++) {
            Library book = books.get(i);
            if (book.getId() == id) {
                books.remove(i);
                return id;
            }
        }
        throw new BookNotFoundException("Book not found with id: " + id);
    }

    @Override
    public Library getBookById(long id) throws BookNotFoundException {
        for (Library book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found with id: " + id);
    }
}