package com.project.Library.Mapper;

import com.project.Library.DTO.LibraryDTO;
import com.project.Library.Model.Library;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibraryMapper implements iMapper<LibraryDTO, Library> {

    @Override
    public LibraryDTO toDTO(Library entity) {
        return entity == null ? null : LibraryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public Library toEntity(LibraryDTO DTO) {
        if (DTO == null)
        {
            return null;
        }

        Library library = new Library();

        library.setId(DTO.getId());
        library.setName(DTO.getName());
        library.setAddress(DTO.getAddress());
        library.setDescription(DTO.getDescription());
        return library;
    }
}
