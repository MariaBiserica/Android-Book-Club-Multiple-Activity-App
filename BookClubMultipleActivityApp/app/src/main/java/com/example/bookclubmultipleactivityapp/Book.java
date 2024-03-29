package com.example.bookclubmultipleactivityapp;

public class Book {
    private String title;
    private String author;
    private String genre;

    // Constructor, getters, and setters
    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
}
