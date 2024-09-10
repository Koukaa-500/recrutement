package com.interview.model.EntityBachka;

import com.interview.model.entity.BaseEntity;
import com.interview.model.entity.Utilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offre {
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
