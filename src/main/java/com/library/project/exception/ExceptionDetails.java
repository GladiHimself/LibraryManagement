package com.library.project.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDetails {
	
	private String message;
	
	private Date timestamp;

}
	
	
