package com.interview.repositoryBachka;

import com.interview.model.EntityBachka.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepository extends JpaRepository<Candidature,Integer> {
}
