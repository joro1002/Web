package com.example.restapi;

import com.example.restapi.services.AuthorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Engine implements CommandLineRunner {
    private final AuthorService authorService;

    public Engine(AuthorService authorService) {
        this.authorService = authorService;
    }


    @Override
    public void run(String... args) throws Exception {
        authorService.seed();
    }
}
