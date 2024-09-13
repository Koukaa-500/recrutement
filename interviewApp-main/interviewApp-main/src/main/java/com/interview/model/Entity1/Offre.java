package com.interview.model.Entity1;


import com.interview.model.Entity1.Enum.OffreStatus;
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
    @GeneratedValue  // Or another strategy like SEQUENCE
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

    @ManyToOne
    private Recruteur recruteur;

}
