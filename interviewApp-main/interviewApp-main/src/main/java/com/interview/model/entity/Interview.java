package com.interview.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Interview  extends BaseEntity{
private String dateHeure;
private String responsable;
private String url;
@ManyToOne(optional = false,fetch = FetchType.EAGER)
private Offre offre;
@ManyToOne(optional = false,fetch = FetchType.EAGER)
private Utilisateur participant;

}
