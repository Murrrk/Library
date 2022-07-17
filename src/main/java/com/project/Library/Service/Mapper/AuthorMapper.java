package com.project.Library.Service.Mapper;

import com.project.Library.DTO.AuthorDTO;
import com.project.Library.Model.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorMapper implements iMapper<AuthorDTO, Author>{

    @Override
    public AuthorDTO toDTO(Author entity) {
        return entity == null ? null : AuthorDTO.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .surname(entity.getSurname())
                .lastName(entity.getLastName())
                .penName(entity.getPenName())
                .age(entity.getAge())
                .birthday(entity.getBirthday())
                .summary(entity.getSummary())
                .build();
    }

    @Override
    public Author toEntity(AuthorDTO DTO) {
        if (DTO == null)
        {
            return null;
        }

        Author author = new Author();

        author.setId(DTO.getId());
        author.setFirstName(DTO.getFirstName());
        author.setSurname(DTO.getSurname());
        author.setLastName(DTO.getLastName());
        author.setPenName(DTO.getPenName());
        author.setAge(DTO.getAge());
        author.setBirthday(DTO.getBirthday());
        author.setSummary(DTO.getSummary());
        return author;
    }


}
