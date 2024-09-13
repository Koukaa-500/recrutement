package com.interview.model.Entity1;

import com.interview.model.Entity1.Enum.CandidatureStatus;
import jakarta.persistence.*;
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
    @GeneratedValue
    private Integer id;
    private CandidatureStatus status;

    private Integer offre;

    private Integer candidat;
    @PrePersist
    public void init()
    {
        this.setStatus(CandidatureStatus.PENDING);
    }
}
