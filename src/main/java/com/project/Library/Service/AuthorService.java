package com.project.Library.Service;

import com.project.Library.DTO.AuthorDTO;
import com.project.Library.Repo.AuthorRepository;
import com.project.Library.Repo.BookRepository;
import com.project.Library.Service.Mapper.AuthorMapper;
import com.project.Library.Service.Mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorMapper authorMapper;

    @Autowired
    BookMapper bookMapper;


    public List<AuthorDTO> getAllAuthors() {
        List<AuthorDTO> authors = authorRepository.findAll().stream().map(authorMapper::toDTO).collect(Collectors.toList());
        for(AuthorDTO author : authors){
            author.setBooks(bookRepository.findAllByAuthorId(author.getId()).stream().map(bookMapper::toDTO).collect(Collectors.toList()));
        }
        return authors;
    }

}
