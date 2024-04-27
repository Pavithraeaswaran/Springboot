package com.example.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    int bookId;
    String bookName;
    String author;
    String genre;
    int price;
    int number_of_volumes;
    int number_of_copies;
    public Book(){
        
    }
    public Book(int bookId, String bookName, String author, String genre, int price, int number_of_volumes,
            int number_of_copies) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.number_of_volumes = number_of_volumes;
        this.number_of_copies = number_of_copies;
    }
    public int getBookId() {
        return bookId;
    }
    
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getNumber_of_volumes() {
        return number_of_volumes;
    }
    public void setNumber_of_volumes(int number_of_volumes) {
        this.number_of_volumes = number_of_volumes;
    }
    public int getNumber_of_copies() {
        return number_of_copies;
    }
    public void setNumber_of_copies(int number_of_copies) {
        this.number_of_copies = number_of_copies;
    }
    
}