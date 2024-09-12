package com.interview.model.DTO1;

import com.interview.model.Entity1.Enum.RoleUtilisateur;
import com.interview.model.Entity1.Interview;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CandidatDto {
    @NotBlank

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank

    private String nom;
    @NotBlank

    private String prenom;
    private Integer age;
    private String email;
    private RoleUtilisateur role;
    @NotBlank

    private List<Interview> interviews;
}
