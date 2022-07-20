package com.example.restapi.services;

public interface AuthorService {
    void seed();
    void initAuthor(String name, String... books);
}

