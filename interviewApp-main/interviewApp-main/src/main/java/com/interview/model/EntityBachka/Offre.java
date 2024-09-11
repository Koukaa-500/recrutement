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
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offre implements Serializable {
    @Id
    private Integer id;
    private String description;
    private String domaine;
    private String nbPoste;
    private String nvEtude;
    private String experience;
    private String ville;
    private LocalDateTime limite;
    private String contractType ;
   @ManyToOne(optional = false,fetch = FetchType.EAGER)
    private Recruteur recruteur;

}
