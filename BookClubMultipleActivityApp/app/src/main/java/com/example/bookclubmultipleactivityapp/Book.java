package com.example.bookclubmultipleactivityapp;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int iconDrawable; // Field to store the drawable resource ID
    private String briefDescription;
    private int coverDrawable; // Field to store the book cover drawable resource

    // Updated constructor to include iconDrawable
    public Book(String title, String author, String genre, int iconDrawable,
                String briefDescription, int coverDrawable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.iconDrawable = iconDrawable;
        this.briefDescription = briefDescription;
        this.coverDrawable = coverDrawable;
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

    public String getBriefDescription() {
        return briefDescription;
    }
    public int getCoverDrawable() {
        return coverDrawable;
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

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public void setCoverDrawable(int coverDrawable) {
        this.coverDrawable = coverDrawable;
    }
}
