package com.interview.model.EntityBachka;

import com.interview.model.EntityBachka.Enum.CandidatureStatus;
import com.interview.model.EntityBachka.Enum.RoleUtilisateur;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidature implements Serializable {
    @Id
    private Integer id;
    private CandidatureStatus status;
    @OneToOne
    private Offre offre;
    @OneToOne
    private Candidat candidat;
    @PrePersist
    public void init()
    {
        this.setStatus(CandidatureStatus.Wait);
    }
}
