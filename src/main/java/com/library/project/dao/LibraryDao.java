package com.library.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.project.model.Library;

public interface LibraryDao extends JpaRepository<Library, Integer> {

}
