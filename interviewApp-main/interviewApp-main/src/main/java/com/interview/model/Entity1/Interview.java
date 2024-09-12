package com.interview.model.Entity1;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private   Integer id;
private String dateHeure;
private String responsable;
private String url;
@ManyToOne(optional = false,fetch = FetchType.EAGER)
private Offre offre;
@ManyToOne(optional = false,fetch = FetchType.EAGER)
private Candidat participant;
}
