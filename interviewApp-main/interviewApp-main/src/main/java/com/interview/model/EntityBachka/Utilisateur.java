package com.interview.model.EntityBachka;

import com.interview.model.EntityBachka.Enum.RoleUtilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Utilisateur {
    @Id
    private Integer id;
    private String nomUtilsateur;
    private String motDePasse;
    private String email;
    private RoleUtilisateur role;
}
