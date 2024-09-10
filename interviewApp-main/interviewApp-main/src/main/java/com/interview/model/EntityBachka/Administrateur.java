package com.interview.model.EntityBachka;

import com.interview.model.EntityBachka.Enum.RoleUtilisateur;
import jakarta.persistence.PrePersist;

public class Administrateur extends Utilisateur{
    @PrePersist
    public void init()
    {
        this.setRole(RoleUtilisateur.admin);
    }
}
