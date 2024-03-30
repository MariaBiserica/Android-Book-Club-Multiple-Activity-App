package com.example.bookclubmultipleactivityapp;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int iconDrawable; // Field to store the drawable resource ID

    // Updated constructor to include iconDrawable
    public Book(String title, String author, String genre, int iconDrawable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.iconDrawable = iconDrawable;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getIconDrawable() {
        return iconDrawable;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setIconDrawable(int iconDrawable) {
        this.iconDrawable = iconDrawable;
    }
}
