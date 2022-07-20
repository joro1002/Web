package com.example.restapi.services.impl;

import com.example.restapi.entities.Author;
import com.example.restapi.entities.Book;
import com.example.restapi.repositories.AuthorRepository;
import com.example.restapi.repositories.BookRepository;
import com.example.restapi.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void seed() {
        initAuthor("Elin Pelin", "Qn Bibiqn", "Pod manastirskata loza");
        initAuthor("Nikolai Haitov", "Divi Razkazi");
        initAuthor("Dimitar Talev", "tutun");
    }

    @Override
    public void initAuthor(String name, String... books) {
        Author(name, authorRepository, bookRepository, books);
    }

    private static void Author(String name, AuthorRepository authorRepository, BookRepository bookRepository, String[] books) {
        Author author = new Author();
        author.setName(name);

        author = authorRepository.save(author);

        List<Book> allBooks = new ArrayList<>();

        for (String book : books) {
            Book aBook = new Book();
            aBook.setAuthor(author);
            aBook.setTitle(book);
            allBooks.add(aBook);
        }
        bookRepository.saveAll(allBooks);
    }
}
