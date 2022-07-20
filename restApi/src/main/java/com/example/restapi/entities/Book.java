package com.example.restapi.entities;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends BaseEntity{
    private String title;
    private Author author;

    public Book() {

    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
