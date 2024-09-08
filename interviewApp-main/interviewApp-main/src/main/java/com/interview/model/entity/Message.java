package com.interview.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Message extends BaseEntity {
	private String texte;
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	private Utilisateur emetteur;
	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	private Utilisateur recepteur;

}
