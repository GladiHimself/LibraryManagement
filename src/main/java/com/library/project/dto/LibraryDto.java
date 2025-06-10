package com.library.project.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibraryDto {

	private int id;
	
	@NotBlank(message = "title cannot be blank")
	private String title;
	
	@NotBlank(message = "author cannot be blank")
	private String author;
	
	@Min(value = 1000, message = "publication year cannot be less than 1000")
	@Max(value = 2025, message = "publication year cannot be more than 2025")
	private int publicationYear;
	
	@NotBlank(message = "genre cannot be blank")
	private String genre;
	
	@Min(value = 1 )
	private double price;
	
}
