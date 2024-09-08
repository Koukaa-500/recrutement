package com.interview.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Candidature extends BaseEntity {
	@Column(columnDefinition = "varchar(30) default 'en attente'")
private String etat;
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	private Utilisateur emetteur;
}
