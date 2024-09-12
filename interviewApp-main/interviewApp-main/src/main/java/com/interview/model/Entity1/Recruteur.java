package com.interview.model.Entity1;

import com.interview.model.Entity1.Enum.RoleUtilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recruteur extends Utilisateur{
    private  String companyName;
    private  int  companySize;

    private  String secteurActivite;

    private  String website;
    @OneToMany
    private List<Offre> offres;
    @PrePersist
    public void init()
    {
        this.setRole(RoleUtilisateur.recruteur
        );
    }

}
