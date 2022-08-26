package com.project.Library.Service;


import com.project.Library.DTO.BookDTO;
import com.project.Library.Model.Book;
import com.project.Library.Repo.BookRepository;
import com.project.Library.Service.Mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookMapper bookMapper;

    public List<BookDTO> getAllBooks(@RequestParam(required = false) String title){

            List<BookDTO> books = new ArrayList<BookDTO>();

            if (title == null)
                books = bookRepository.findAll().stream().map(book -> bookMapper.toDTO(book)).collect(Collectors.toList());
            else
                books = bookRepository.findByTitle(title).stream().map(book -> bookMapper.toDTO(book)).collect(Collectors.toList());

            return books;

    }

    public BookDTO getBookId(@PathVariable("id") Long id) {
        return bookMapper.toDTO(bookRepository.findById(id));
    }

    public BookDTO createBook(BookDTO book) {
        Book entity = bookMapper.toEntity(book);

        BookDTO returnBook = bookMapper.toDTO(bookRepository.save(entity));
        return returnBook;
    }

    public Boolean deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return true;
    }

    public BookDTO updateBook(BookDTO book, Integer id) {
        Book entity = bookRepository.findById(id).orElse(null);
        if(entity == null){
            return null;
        }

        Book returnBook = bookMapper.toEntity(book);

        entity.setTitle(book.getTitle());
        entity.setIsbn(book.getIsbn());
        entity.setDescription(book.getDescription());
        entity.setDateOfArrival(book.getDateOfArrival());
        entity.setAuthor(returnBook.getAuthor());

        return bookMapper.toDTO(bookRepository.save(entity));
    }

    public List<BookDTO> getAllBooksByAuthor(Integer id) {
        List<BookDTO> books = bookRepository.findAllByAuthorId(id).stream().map(bookMapper::toDTO).collect(Collectors.toList());
        return books;
    }

}
