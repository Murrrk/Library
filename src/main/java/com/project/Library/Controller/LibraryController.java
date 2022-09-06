package com.project.Library.Controller;

import com.project.Library.DTO.LibraryDTO;
import com.project.Library.Service.LibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
@AllArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping("/all")
    public ResponseEntity<List<LibraryDTO>> getAllLibraries(@RequestParam(required = false) String name){
        return new ResponseEntity<>(libraryService.getAllLibraries(name), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryDTO> getLibraryId(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(libraryService.getLibraryId(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<LibraryDTO> addLibrary(@RequestBody(required = true) LibraryDTO library) {
        return new ResponseEntity<>(libraryService.createLibrary(library), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteLibrary(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(libraryService.deleteLibrary(id), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<LibraryDTO> updateBook(@RequestBody LibraryDTO library, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(libraryService.updateLibrary(library, id), new HttpHeaders(), HttpStatus.OK);
    }
}
