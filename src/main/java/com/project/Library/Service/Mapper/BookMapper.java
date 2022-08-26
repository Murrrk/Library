package com.project.Library.Service.Mapper;

import com.project.Library.DTO.BookDTO;
import com.project.Library.Model.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookMapper implements iMapper<BookDTO, Book> {

    private final AuthorMapper authorMapper;

    @Override
    public BookDTO toDTO(Book entity) {
        return entity == null ? null : BookDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .isbn(entity.getIsbn())
                .description(entity.getDescription())
                .aut(authorMapper.toDTO(entity.getAuthor()))
                .dateOfArrival(entity.getDateOfArrival())
                .build();
    }

    @Override
    public Book toEntity(BookDTO DTO) {
        if (DTO == null)
        {
            return null;
        }

        Book book = new Book();

        book.setId(DTO.getId());
        book.setTitle(DTO.getTitle());
        book.setIsbn(DTO.getIsbn());
        book.setDescription(DTO.getDescription());
        book.setAuthor(authorMapper.toEntity(DTO.getAut()));
        book.setDateOfArrival(DTO.getDateOfArrival());
        return book;
    }
}
