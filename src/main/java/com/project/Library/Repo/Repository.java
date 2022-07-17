package com.project.Library.Repo;

import com.project.Library.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository <Book,Integer>{
    List<Book> findByTitle(String title);

    Optional<Book> findById(Long id);
}
