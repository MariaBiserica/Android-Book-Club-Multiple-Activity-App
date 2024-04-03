package com.example.bookclubmultipleactivityapp;

public class Book {
    private String title;
    private String author;
    private String genre;
    private int iconDrawable; // Field to store the drawable resource ID
    private int coverDrawable; // Field to store the book cover drawable resource
    private String briefDescription;
    private String fullDescription;
    private float rating; // Assume rating is a value from 0 to 5
    private int numberOfRatings;
    private int numberOfReviews;
    private int numberOfPages;
    private String publishingDate;

    // Updated constructor to include iconDrawable
    public Book(String title, String author, String genre, int iconDrawable,
                int coverDrawable, String briefDescription,
                String fullDescription, float rating, int numberOfRatings,
                int numberOfReviews, int numberOfPages, String publishingDate) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.iconDrawable = iconDrawable;
        this.coverDrawable = coverDrawable;
        this.briefDescription = briefDescription;
        this.fullDescription = fullDescription;
        this.rating = rating;
        this.numberOfRatings = numberOfRatings;
        this.numberOfReviews = numberOfReviews;
        this.numberOfPages = numberOfPages;
        this.publishingDate = publishingDate;
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

    public int getCoverDrawable() {
        return coverDrawable;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public float getRating() {
        return rating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getPublishingDate() {
        return publishingDate;
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

    public void setCoverDrawable(int coverDrawable) {
        this.coverDrawable = coverDrawable;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setPublishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }
    
}
