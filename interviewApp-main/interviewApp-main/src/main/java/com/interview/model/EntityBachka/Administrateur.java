package com.interview.model.EntityBachka;

import com.interview.model.EntityBachka.Enum.RoleUtilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Getter
@Setter

public class Administrateur extends Utilisateur implements Serializable {
    @PrePersist
    public void init()
    {
        this.setRole(RoleUtilisateur.admin);
    }
}
