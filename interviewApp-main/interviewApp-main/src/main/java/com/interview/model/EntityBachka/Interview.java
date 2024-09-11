package com.interview.model.EntityBachka;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Interview implements Serializable {
    @Id
    private   Integer id;
private String dateHeure;
private String responsable;
private String url;
@ManyToOne(optional = false,fetch = FetchType.EAGER)
private Offre offre;
@ManyToOne(optional = false,fetch = FetchType.EAGER)
private Candidat participant;
}
