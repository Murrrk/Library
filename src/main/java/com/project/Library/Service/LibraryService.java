package com.project.Library.Service;

import com.project.Library.DTO.LibraryDTO;
import com.project.Library.Mapper.LibraryMapper;
import com.project.Library.Model.Library;
import com.project.Library.Repo.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LibraryService {


    private final LibraryMapper librariesMapper;

    private final LibraryRepository libraryRepository;


    public List<LibraryDTO> getAllLibraries(@RequestParam(required = false) String name){

        List<LibraryDTO> libraries = new ArrayList<LibraryDTO>();

        if (name == null)
            libraries = libraryRepository.findAll().stream().map(library -> librariesMapper.toDTO(library)).collect(Collectors.toList());
        else
            libraries = libraryRepository.findByName(name).stream().map(library -> librariesMapper.toDTO(library)).collect(Collectors.toList());

        return libraries;

    }

    public LibraryDTO getLibraryId(Integer id) {
        return librariesMapper.toDTO(libraryRepository.findById(id).orElse(null));
    }

    public LibraryDTO createLibrary(LibraryDTO library) {
        Library entity = librariesMapper.toEntity(library);

        LibraryDTO returnLibrary = librariesMapper.toDTO(libraryRepository.save(entity));
        return returnLibrary;
    }

    public Boolean deleteLibrary(Integer id) {
        libraryRepository.deleteById(id);
        return true;
    }

    public LibraryDTO updateLibrary(LibraryDTO library, Integer id) {
        Library entity = libraryRepository.findById(id).orElse(null);
        if(entity == null){
            return null;
        }

        Library returnLibrary = librariesMapper.toEntity(library);

        entity.setName(library.getName());
        entity.setAddress(library.getAddress());
        entity.setDescription(library.getDescription());

        return librariesMapper.toDTO(libraryRepository.save(entity));
    }
}
