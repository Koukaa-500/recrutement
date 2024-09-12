package com.interview.model.Entity1;

import com.interview.model.Entity1.Enum.RoleUtilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import lombok.Getter;
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
