package com.library.library.services;


import com.library.library.entities.Library;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibraryService {

        Library returnBooks(Library library);

        List<Library> getAllBooks();

        Library updateBooks(long id, Library library);

        Long borrowBooks(Long id);

        Library getBooksById(Long id);
    }