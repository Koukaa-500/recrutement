package com.interview.model.dto;

import java.util.List;

import lombok.Data;
@Data
public class CandidatureDto extends BaseDTO {
	private String etat;
	private UtilisateurDto emetteur;
}
