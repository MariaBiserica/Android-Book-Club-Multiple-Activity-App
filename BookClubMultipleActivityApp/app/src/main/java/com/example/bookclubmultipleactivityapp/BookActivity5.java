package com.example.bookclubmultipleactivityapp;

public class BookActivity5 {
    private long id; // For database operations
    private String title;
    private String author;
    private String genre;
    private int numberOfPages;

    // Constructor
    public BookActivity5(String title, String author, String genre, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
