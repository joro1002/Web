package com.example.restapi.web;

import com.example.restapi.entities.Author;
import com.example.restapi.entities.Book;
import com.example.restapi.repositories.AuthorRepository;
import com.example.restapi.repositories.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class BooksController implements AuthorsNamespace{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BooksController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{authorId}/books")
    public ResponseEntity<List<Book>> getAuthorsBooks(@PathVariable Long authorId){
        Optional<Author> byId = authorRepository.findById(authorId);

        return byId
                .map(Author::getBooks).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{authorId}/books/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable Long authorId,
                                        @PathVariable Long bookId){
        Optional<Book> byId = this.bookRepository.findById(bookId);

        return byId.filter(b -> b.getAuthor().getId().equals(authorId))
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
