package com.interview.model.DTOBachka;

import com.interview.model.dto.UtilisateurDto;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class OffreDto {
    @NotBlank
    private Integer id;
    @NotBlank
    private String titre;
    @NotBlank
    private String description;
    @Future
    private LocalDateTime limite;
    private UtilisateurDto recruteur;
}

