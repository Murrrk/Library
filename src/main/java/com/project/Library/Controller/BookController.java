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
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getAllBooks(@RequestParam(required = false) String title){
        return new ResponseEntity<>(bookService.getAllBooks(title), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(bookService.getBookId(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BookDTO> addBook(@RequestBody(required = true) BookDTO book) {
        return new ResponseEntity<>(bookService.createBook(book), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(bookService.deleteBook(id), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO book, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(bookService.updateBook(book, id), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<List<BookDTO>> getAllBooksByAuthor(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(bookService.getAllBooksByAuthor(id), new HttpHeaders(), HttpStatus.OK);
    }
}
