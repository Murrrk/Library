package com.project.Library.Service.Mapper;

import com.project.Library.DTO.LibrariesDTO;
import com.project.Library.Model.Libraries;

public class LibrariesMapper implements iMapper<LibrariesDTO, Libraries> {

    @Override
    public LibrariesDTO toDTO(Libraries entity) {
        return entity == null ? null : LibrariesDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .description(entity.getDescription())
                .build();
    }

    @Override
    public Libraries toEntity(LibrariesDTO DTO) {
        if (DTO == null)
        {
            return null;
        }

        Libraries libraries = new Libraries();

        libraries.setId(DTO.getId());
        libraries.setName(DTO.getName());
        libraries.setAddress(DTO.getAddress());
        libraries.setDescription(DTO.getDescription());
        return libraries;
    }
}
