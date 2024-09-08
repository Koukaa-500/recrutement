package com.interview.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MessageDto {
	@NotBlank
	@Size(min = 2)
	private String texte;
	private UtilisateurDto emetteur;
	private UtilisateurDto recepteur;
	

}
