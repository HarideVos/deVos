package com.library.library.controllers;

import com.library.library.dtos.LibraryDto;
import com.library.library.entities.Library;
import com.library.library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/return")
    public ResponseEntity<Library> returnBooks(@RequestBody Library library) {
        Library returnedLibrary = libraryService.returnBooks(library);
        return new ResponseEntity<>(returnedLibrary, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Library>> getAllBooks() {
        List<Library> books = libraryService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Library> updateBooks(@PathVariable Long id, @RequestBody Library library) {
        Library updatedLibrary = libraryService.updateBooks(id, library);
        return new ResponseEntity<>(updatedLibrary, HttpStatus.OK);
    }

    @PostMapping("/{id}/borrow")
    public ResponseEntity<Long> borrowBooks(@PathVariable Long id) {
        Long borrowedId = libraryService.borrowBooks(id);
        return new ResponseEntity<>(borrowedId, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> getBooksById(@PathVariable Long id) {
        Library library = libraryService.getBooksById(id);
        return new ResponseEntity<>(library, HttpStatus.OK);
    }
}