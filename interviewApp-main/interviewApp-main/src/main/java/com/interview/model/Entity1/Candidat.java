package com.interview.model.Entity1;

import com.interview.model.Entity1.Enum.RoleUtilisateur;
import jakarta.persistence.Entity;
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
public class Candidat extends Utilisateur  {
   private List<String> education;
    private   List<String> skills;
    private  List<String> certificates;
    private  List<Integer> offres;

    private  List<Interview> interviews;
    @PrePersist
    public void init()
    {
        this.setRole(RoleUtilisateur.candidat);
    }
}
