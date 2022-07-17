package com.project.Library.Controller;

import com.project.Library.Model.Book;
import com.project.Library.Repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    Repository repository;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String title){
        try {
            List<Book> books = new ArrayList<Book>();

            if (title == null)
                repository.findAll().forEach(books::add);
            else
                repository.findByTitle(title).forEach(books::add);

            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookId(@PathVariable("id") Long id) {
        Optional<Book> bookData = repository.findById(id);
        if (bookData.isPresent()) {
            return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
