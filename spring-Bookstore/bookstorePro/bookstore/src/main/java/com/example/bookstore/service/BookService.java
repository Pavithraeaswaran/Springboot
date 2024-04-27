package com.example.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.bookstore.model.*;
import com.example.bookstore.repository.*;

@Service
public class BookService {
    @Autowired

    BookRepo br;

    // post
    public Book create(Book b) {
        return br.save(b);
    }

    // getbyid
    public Book getbyid(int ProductId) {
        return br.findById(ProductId).orElse(null);

    }

    public List<Book> getbysort(String field) {
        return br.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    // put
    public boolean updateDetails(int productId, Book b) {
        if (br.findById(productId) == null) {
            return false;
        }
        try {
            br.save(b);

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteEmployee(int employeeId) {
        if (this.getbyid(employeeId) == null) {
            return false;
        }
        br.deleteById(employeeId);
        return true;
    }

    public List<Book> getAllBooks() {
        return br.findAll();   
     }

}