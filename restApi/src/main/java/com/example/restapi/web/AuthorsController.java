package com.example.restapi.web;

import com.example.restapi.entities.Author;
import com.example.restapi.repositories.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorsController implements AuthorsNamespace{
    private final AuthorRepository authorRepository;

    public AuthorsController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long authorId){
        Optional<Author> byId = authorRepository.findById(authorId);
        return byId.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Author> create( UriComponentsBuilder ucBuilder,
                                          @RequestBody Author author  ){
        Author newAuthor = authorRepository.save(author);
        return ResponseEntity
                .created(ucBuilder.path("/authors/{authorId}").buildAndExpand(newAuthor.getId()).toUri()).build();
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long authorId){
        this.authorRepository.deleteById(authorId);

        return ResponseEntity.noContent().build();
    }
}
