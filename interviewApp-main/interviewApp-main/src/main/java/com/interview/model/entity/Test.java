package com.interview.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Test extends BaseEntity {
	private String titre;
	private String dateHeure;
	
	private String fichier;
	private String description;
	@ManyToMany(mappedBy = "tests")
	List<Utilisateur> utilisateurs;

}
