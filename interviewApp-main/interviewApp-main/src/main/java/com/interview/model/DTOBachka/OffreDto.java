package com.interview.model.DTOBachka;

import com.interview.model.EntityBachka.Enum.OffreStatus;
import com.interview.model.EntityBachka.Recruteur;
import com.interview.model.EntityBachka.Utilisateur;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class OffreDto {

    private Integer id;
    @NotBlank

    private String description;
    @NotBlank
    private String domaine;
    @NotBlank
    private String nbPoste;
    @NotBlank
    private String nvEtude;
    @NotBlank
    private String experience;
    @NotBlank
    private String ville;
    @NotBlank
    @Enumerated(EnumType.STRING)  // Persist enum as a string in the database

    private OffreStatus status;

    @NotBlank
    private LocalDateTime limite;
    @NotBlank
    private String contractType ;
    @NotBlank
    private Integer recruteur;

}

