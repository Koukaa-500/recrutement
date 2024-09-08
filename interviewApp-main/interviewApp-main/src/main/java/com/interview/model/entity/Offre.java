package com.interview.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Offre extends BaseEntity{
	private String titre;
	private String description;
	private LocalDateTime limite;
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	private Utilisateur recruteur;

}
