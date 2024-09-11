package com.interview.model.DTOBachka;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class InterviewDto {
    @NotBlank
    private Integer id;
    @NotBlank

    private String dateHeure;
    @NotBlank
    private String responsable;
    @NotBlank
    private String url;
}
