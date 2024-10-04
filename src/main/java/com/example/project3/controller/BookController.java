package com.example.project3.controller;

import com.example.project3.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class BookController {

    private final Map<Long, Book> bookStorage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(); 

    @PostMapping("/book")
    public ResponseEntity<Map<String, Object>> receiveBook(@RequestBody Book book) {
        Long id = idGenerator.incrementAndGet();
        book.setId(id);
        bookStorage.put(id, book);
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);
        response.put("title", book.getTitle());
        response.put("author", book.getAuthor());
        response.put("status", "received");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = new ArrayList<>(bookStorage.values());
        return ResponseEntity.ok(books);
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookStorage.get(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

