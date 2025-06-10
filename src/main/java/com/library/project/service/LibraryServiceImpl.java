package com.library.project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.project.dao.LibraryDao;
import com.library.project.dto.LibraryDto;
import com.library.project.exception.BookNotFound;
import com.library.project.model.Library;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	LibraryDao libraryDao;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public LibraryDto saveNewBook(LibraryDto libraryDto) {
		Library library = modelMapper.map(libraryDto, Library.class);
		return modelMapper.map(libraryDao.save(library), LibraryDto.class);
	}

	@Override
	public List<LibraryDto> getAllBooks() {
		return libraryDao.findAll().stream()
						 .map(x -> modelMapper.map(x, LibraryDto.class))
						 .collect(Collectors.toList());
	}

	@Override
	public LibraryDto getBookByBookId(int id) throws BookNotFound {
		Optional<Library> lib = libraryDao.findById(id);
		if(lib.isPresent()) {
			return modelMapper.map(lib.get(), LibraryDto.class);
		} else {
			throw new BookNotFound("Book is not available");
		}
	}

	@Override
	public boolean deleteBook(int id) throws BookNotFound {
		Optional<Library> lib = libraryDao.findById(id);
		if(lib.isPresent()) {
			libraryDao.deleteById(id);
			return true;
		} else {
			throw new BookNotFound("Book is not available");
		}
	}

}
