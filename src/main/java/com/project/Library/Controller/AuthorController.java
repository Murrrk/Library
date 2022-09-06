package com.project.Library.Controller;

import com.project.Library.DTO.AuthorDTO;
import com.project.Library.Service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/author")

public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/all")
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(@RequestParam(required = false) String penName){
        return new ResponseEntity<>(authorService.getAllAuthors(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(authorService.getAuthorId(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody(required = true) AuthorDTO author) {
        return new ResponseEntity<>(authorService.createAuthor(author), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteAuthor(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(authorService.deleteAuthor(id), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@RequestBody AuthorDTO author, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(authorService.updateAuthor(author, id), new HttpHeaders(), HttpStatus.OK);
    }

}
