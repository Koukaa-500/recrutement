package com.interview.repositoryBachka;

import com.interview.model.EntityBachka.Candidature;
import com.interview.model.EntityBachka.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CandidatureRepository extends JpaRepository<Candidature,Integer> {
    Integer countByOffre(Offre offre);
}
