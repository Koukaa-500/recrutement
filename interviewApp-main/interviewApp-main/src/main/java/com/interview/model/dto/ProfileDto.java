package com.interview.model.dto;

import com.interview.model.entity.Utilisateur;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProfileDto {
	private long id;
	@NotBlank
	private String curriculum;
	@Size(min = 8,max = 16)
	private String numero;
	
	private Utilisateur utilisateur;
}
