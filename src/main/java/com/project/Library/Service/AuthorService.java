package com.project.Library.Service;

import com.project.Library.DTO.AuthorDTO;
import com.project.Library.Model.Author;
import com.project.Library.Repo.AuthorRepository;
import com.project.Library.Repo.BookRepository;
import com.project.Library.Mapper.AuthorMapper;
import com.project.Library.Mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public AuthorDTO getAuthorId(@PathVariable("id") Integer id) {
        return authorMapper.toDTO(authorRepository.findById(id).orElse(null));
    }

    public AuthorDTO createAuthor(AuthorDTO author) {
        Author entity = authorMapper.toEntity(author);

        AuthorDTO returnAuthor = authorMapper.toDTO(authorRepository.save(entity));
        return returnAuthor;
    }

    public Boolean deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
        return true;
    }

    public AuthorDTO updateAuthor(AuthorDTO author, Integer id) {
        Author entity = authorRepository.findById(id).orElse(null);
        if(entity == null){
            return null;
        }

        Author returnAuthor = authorMapper.toEntity(author);

        entity.setFirstName(author.getFirstName());
        entity.setSurname(author.getSurname());
        entity.setLastName(author.getLastName());
        entity.setPenName(author.getPenName());
        entity.setAge(author.getAge());
        entity.setBirthday(author.getBirthday());
        entity.setSummary(author.getSummary());

        return authorMapper.toDTO(authorRepository.save(entity));
    }

}
