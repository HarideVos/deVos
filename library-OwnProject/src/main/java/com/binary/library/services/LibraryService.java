package com.binary.library.services;

import com.binary.library.dtos.LibraryDto;
import com.binary.library.entities.Library;
import com.binary.library.exceptions.BookNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LibraryService {
    List<Library> getAllBooks();
    Library createBook(@Valid LibraryDto bookDto);
    Library updateBook(long id, @Valid LibraryDto updatedBook) throws BookNotFoundException;
    Long deleteBook(long id) throws BookNotFoundException;
    Library getBookById(long id) throws BookNotFoundException;
}