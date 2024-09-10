package com.interview.model.DTOBachka;

import com.interview.model.EntityBachka.Candidat;
import com.interview.model.EntityBachka.Enum.CandidatureStatus;
import com.interview.model.EntityBachka.Offre;
import com.interview.model.dto.UtilisateurDto;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CandidatureDto {
    @NotBlank
    private Integer id;
    @NotBlank
    private Offre offre;
    @NotBlank
    private Candidat candidat;
}

