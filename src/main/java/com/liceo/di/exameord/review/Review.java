package com.liceo.di.exameord.review;

import java.time.LocalDate;

public class Review {
    private String author;
    private String text;
    private LocalDate datePublished;
    private int likes;
    private int dislikes;
    private int id;

    public Review() {
        this.id = 0;
        this.likes = 0;
        this.dislikes = 0;
    }

    public Review(String author, String title) {
        this();
        this.author = author;
        this.text = title;
    }

    public Review(String author, String title, LocalDate datePublished) {
        this(author, title);
        this.datePublished = datePublished;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nReview{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                ", datePublished=" + datePublished +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", id=" + id +
                "}";
    }

    public void like() {
        this.likes++;
    }

    public void dislike() {
        this.dislikes++;
    }
}
