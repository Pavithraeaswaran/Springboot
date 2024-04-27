package com.example.bookstore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstore.model.*;
import com.example.bookstore.service.*;

@RestController
public class BookController {
    @Autowired
    BookService bs;

    @SuppressWarnings("null")
    @GetMapping("/api/book/{productId}")
    public ResponseEntity<Book> getProductById(@PathVariable("productId") int productId) {
        Book product = bs.getbyid(productId);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bs.getAllBooks();
        if (books != null && !books.isEmpty()) {
            return new ResponseEntity<>(books, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/api/sort/{field}")
    public ResponseEntity<List<Book>> get(@PathVariable String field) {
        try {
            return new ResponseEntity<>(bs.getbysort(field), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/api/book")
    public ResponseEntity<Book> adddata(@RequestBody Book b) {
        Book obj = bs.create(b);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @SuppressWarnings("null")
    @PutMapping("/api/book/{productId}")
    public ResponseEntity<Book> putMethod(@PathVariable("productId") int productId, @RequestBody Book pd) {
        if (bs.updateDetails(productId, pd) == true) {
            return new ResponseEntity<>(pd, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/api/book/{productId}")
    public ResponseEntity<Boolean> delete(@PathVariable("productId") int productId) {
        if (bs.deleteEmployee(productId) == true) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

}
