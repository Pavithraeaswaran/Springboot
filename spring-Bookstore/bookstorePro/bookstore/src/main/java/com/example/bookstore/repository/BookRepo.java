package com.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstore.model.*;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

}
