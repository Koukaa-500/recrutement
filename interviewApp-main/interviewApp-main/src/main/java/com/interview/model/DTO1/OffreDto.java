package com.interview.model.DTO1;

import com.interview.model.Entity1.Enum.OffreStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

