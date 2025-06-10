package com.library.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.project.dto.LibraryDto;
import com.library.project.exception.BookNotFound;
import com.library.project.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

	
	@Autowired
	LibraryService libraryService;
	
	@PostMapping
	public ResponseEntity<LibraryDto> NewBook(@Validated @RequestBody LibraryDto libraryDto){
		LibraryDto library = libraryService.saveNewBook(libraryDto);
		return new ResponseEntity<>(library, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<LibraryDto>> AllBooks(){
		List<LibraryDto> library = libraryService.getAllBooks();
		return new ResponseEntity<>(library, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LibraryDto> getBookById(@PathVariable int id) throws BookNotFound{
		LibraryDto library = libraryService.getBookByBookId(id);
		return new ResponseEntity<>(library, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable int id) throws BookNotFound{
		boolean isRemoved = libraryService.deleteBook(id);
		
		if(isRemoved) {
			return new ResponseEntity<String>("Book Deleted", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<String>("Provided Book Details is not Present", HttpStatus.NOT_FOUND);
		}
	}
	
}
