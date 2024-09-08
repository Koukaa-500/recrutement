package com.interview.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
public class TestDto extends BaseDTO{
	@NotBlank
	@Size(min = 3)
	private String titre;
	@NotBlank
	private String dateHeure;
	@NotBlank
	private String fichier;
	@NotBlank
	private String description;
	@JsonIgnoreProperties("test")

	List<UtilisateurDto> utilisateurs;
}
