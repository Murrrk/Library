package com.project.Library.Repo;

import com.project.Library.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository <Book,Integer>{
    List<Book> findByTitle(String title);
}
