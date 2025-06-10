package com.library.project.service;

import java.util.List;

import com.library.project.dto.LibraryDto;
import com.library.project.exception.BookNotFound;

public interface LibraryService {
	
	public LibraryDto saveNewBook(LibraryDto libraryDto);
	public List<LibraryDto> getAllBooks();
	public LibraryDto getBookByBookId(int id) throws BookNotFound;
	public boolean deleteBook(int id) throws BookNotFound;
	

}
