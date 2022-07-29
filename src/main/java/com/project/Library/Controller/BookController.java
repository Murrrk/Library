package com.project.Library.Controller;

import com.project.Library.DTO.BookDTO;
import com.project.Library.Model.Book;
import com.project.Library.Repo.BookRepository;
import com.project.Library.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;


    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getAllBooks(@RequestParam(required = false) String title){
        return new ResponseEntity<>(bookService.getAllBooks(title), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDTO> getBookId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookService.getBookId(id), HttpStatus.OK);
    }

    @PostMapping("/books/add")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO newBook) {
        try {

            BookDTO book = bookRepository.save(newBook);

            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
