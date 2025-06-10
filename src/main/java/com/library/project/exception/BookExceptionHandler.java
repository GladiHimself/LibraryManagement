package com.library.project.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class BookExceptionHandler {
	
	@ExceptionHandler(BookNotFound.class)
	public ResponseEntity<?> bookNotFoundException(BookNotFound bf, WebRequest request){
		ExceptionDetails exceptionDetails = new ExceptionDetails( bf.getMessage(), new Date() );
		return new ResponseEntity<>(exceptionDetails, HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionDetails> validationError(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		ExceptionDetails exceptionDetails = new ExceptionDetails(errors.toString(), new Date());
		return new ResponseEntity<ExceptionDetails>(exceptionDetails, HttpStatus.BAD_REQUEST); 
	}
	

}
