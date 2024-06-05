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
    Library updateBook(Long id, @Valid LibraryDto updatedBook) throws BookNotFoundException;
    Long deleteBook(Long id) throws BookNotFoundException;
    Library getBookById(Long id) throws BookNotFoundException;
}