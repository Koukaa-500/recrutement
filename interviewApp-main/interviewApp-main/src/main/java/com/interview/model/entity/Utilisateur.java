package com.interview.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Utilisateur  extends BaseEntity{

@Column(nullable = false)
private String nom;
@Column(nullable = false)
private String prenom;
@Column(nullable = false,unique = true)
private String email;
@Column(nullable = false)
private String mdp;
@Enumerated(EnumType.STRING)
private Grades grade;
@OneToOne(mappedBy = "utilisateur")
@JsonIgnoreProperties("utilisateur")

private Profile profile;
@ManyToMany(cascade = {
		CascadeType.PERSIST,
		CascadeType.MERGE
})
private List<Test> tests;
@OneToMany(mappedBy = "emetteur")
@JsonIgnoreProperties("emetteur")
private List<Candidature> candidatures;
@OneToMany(mappedBy = "emetteur")
@JsonIgnoreProperties("emetteur")
private List<Message> envoyees;
@OneToMany(mappedBy = "recepteur")
@JsonIgnoreProperties("recepteur")
private List<Message> recus;
@OneToMany(mappedBy = "recruteur")
@JsonIgnoreProperties("recruteur")
private List<Offre> offres;


}
