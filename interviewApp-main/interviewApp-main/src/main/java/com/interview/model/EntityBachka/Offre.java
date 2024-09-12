package com.interview.model.EntityBachka;


import com.interview.model.EntityBachka.Enum.OffreStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // or GenerationType.AUTO
    private Integer id;
    private String description;
    private String domaine;
    private String nbPoste;
    private String nvEtude;
    private String experience;
    private String ville;
    @Enumerated(EnumType.STRING)  // Persist enum as a string in the database

    private OffreStatus status;
    private LocalDateTime limite;
    private String contractType ;

    @OneToOne
    private Recruteur recruteur;

}
