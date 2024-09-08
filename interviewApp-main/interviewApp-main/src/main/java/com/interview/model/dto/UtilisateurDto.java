package com.interview.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.interview.model.entity.Grades;
import com.interview.model.entity.Offre;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class UtilisateurDto  extends BaseDTO{
	@NotBlank
	private String nom;
	@NotBlank
	private String prenom;
	@Positive
	@Min(value = 18)
	
	private int age;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	@Size(min = 6,max = 20)
	private String mdp;
	
	private Grades grade;
	@JsonIgnoreProperties("utilisateur")

	private ProfileDto profile;
	@JsonIgnoreProperties("utilisateurs")

	private List<TestDto> tests;
	@JsonIgnoreProperties("recruteur")
	private List<OffreDto> offres;
}
