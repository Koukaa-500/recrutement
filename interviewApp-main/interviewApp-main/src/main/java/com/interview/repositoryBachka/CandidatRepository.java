package com.interview.repositoryBachka;

import com.interview.model.EntityBachka.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatRepository extends JpaRepository<Candidat,Integer> {
    boolean existsByEmail(String email);

    Optional<Candidat> findByEmail(String email);
}
