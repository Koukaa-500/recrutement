package com.interview.model.DTO1;

import com.interview.model.Entity1.Candidat;
import com.interview.model.Entity1.Offre;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CandidatureDto {
    @NotBlank
    private Integer id;
    @NotBlank
    private Offre offre;
    @NotBlank
    private Candidat candidat;
}

