package com.interview.model.DTOBachka;

import com.interview.model.EntityBachka.Recruteur;
import com.interview.model.EntityBachka.Utilisateur;
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
    private LocalDateTime limite;
    @NotBlank
    private String contractType ;
    @NotBlank
    private Integer recruteur;

}

