package com.binary.shop.advices;

import com.binary.shop.exceptions.ItemNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopExceptionHandlerTest {

    @InjectMocks
    private ShopExceptionHandler shopExceptionHandler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHandleItemNotFoundException() {
        ItemNotFoundException exception = new ItemNotFoundException("Item not found");
        ResponseEntity<Object> responseEntity = shopExceptionHandler.handleItemNotFoundException(exception);

        Map<String, String> expectedErrorMap = new HashMap<>();
        expectedErrorMap.put("Message", "Item not found");
        expectedErrorMap.put("TimeStamp", responseEntity.getBody().get("TimeStamp").toString());
        expectedErrorMap.put("httpStatus", HttpStatus.NOT_FOUND.toString());

        assertEquals(expectedErrorMap, responseEntity.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void testHandleMethodArgumentNotValidException() {
        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, null);
        ResponseEntity<Object> responseEntity = shopExceptionHandler.handelMethodArgumentNotValidException(exception);

        Map<String, String> expectedErrorMap = new HashMap<>();
        // Add your expected error messages based on your test case

        assertEquals(expectedErrorMap, responseEntity.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    public void testNoResourceFoundException() {
        NoResourceFoundException exception = new NoResourceFoundException("Resource not found");
        ResponseEntity<Object> responseEntity = shopExceptionHandler.noResourceFoundException(exception);

        Map<String, String> expectedErrorMap = new HashMap<>();
        expectedErrorMap.put("Message", "Resource not found");
        expectedErrorMap.put("TimeStamp", responseEntity.getBody().get("TimeStamp").toString());
        expectedErrorMap.put("httpStatus", HttpStatus.NOT_FOUND.getReasonPhrase());

        assertEquals(expectedErrorMap, responseEntity.getBody());
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}