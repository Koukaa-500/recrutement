package com.interview.model.DTO1;

import com.interview.model.Entity1.Candidat;
import com.interview.model.Entity1.Enum.CandidatureStatus;
import com.interview.model.Entity1.Offre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CandidatureDto {
    @NotNull
    private Integer id;
    @NotBlank

    private CandidatureStatus status;

    @NotBlank
    private Integer offre;
    @NotBlank
    private Integer candidat;
}

