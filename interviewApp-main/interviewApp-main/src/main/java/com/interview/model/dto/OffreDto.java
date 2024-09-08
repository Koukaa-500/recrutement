package com.interview.model.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class OffreDto extends BaseDTO {
	@NotBlank
	private String titre;
	@NotBlank
	private String description;
	@Future
	private LocalDateTime limite;
	private UtilisateurDto recruteur;

}
