package com.binary.library.exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class BookNotFoundExceptionTest {

    @Test
    void testConstructorWithMessage() {
        String message = "Book not found";
        BookNotFoundException exception = new BookNotFoundException(message);
        assertEquals(message, exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        String message = "Book not found";
        Throwable cause = new RuntimeException("Internal error");
        BookNotFoundException exception = new BookNotFoundException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }
}
