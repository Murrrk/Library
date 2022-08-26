package com.project.Library.Controller;

import com.project.Library.DTO.AuthorDTO;
import com.project.Library.Service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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



}
