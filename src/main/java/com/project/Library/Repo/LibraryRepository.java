package com.project.Library.Repo;

import com.project.Library.Model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

    List<Library> findByName(String name);
}
