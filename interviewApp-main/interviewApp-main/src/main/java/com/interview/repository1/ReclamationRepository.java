package com.interview.repository1;

import com.interview.model.Entity1.Candidat;
import com.interview.model.Entity1.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {
    List<Reclamation> findByCandidat(Candidat candidat);
}
