package com.project.Library.Controller;

import com.project.Library.DTO.BookDTO;
import com.project.Library.Service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getAllBooks(@RequestParam(required = false) String title){
        return new ResponseEntity<>(bookService.getAllBooks(title), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDTO> getBookId(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookService.getBookId(id), HttpStatus.OK);
    }

    @PostMapping("/books/add")
    public ResponseEntity<BookDTO> addBook(@RequestBody(required = true) BookDTO book) {
        return new ResponseEntity<>(bookService.createBook(book), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/books/delete/{id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookService.deleteBook(id), new HttpHeaders(), HttpStatus.OK);
    }
}
