package com.example.restapi;

import com.example.restapi.entities.Author;
import com.example.restapi.entities.Book;
import com.example.restapi.repositories.AuthorRepository;
import com.example.restapi.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Engine implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public Engine(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initNikiHaitov();
        initDimitarTalev();
        initElinPelin();
    }

    private void initElinPelin(){
        initAuthor("Elin Pelin", "Qn Bibiqn", "Pod manastirskata loza");
    }
    private void initNikiHaitov(){
        initAuthor("Nikolai Haitov", "Divi Razkazi");
    }

    private void initDimitarTalev(){
        initAuthor("Dimitar Talev", "tutun");
    }

    private void initAuthor(String name, String... books){
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
