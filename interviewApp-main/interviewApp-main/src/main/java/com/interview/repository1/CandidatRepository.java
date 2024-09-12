package com.interview.repository1;

import com.interview.model.Entity1.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface CandidatRepository extends JpaRepository<Candidat,Integer> {
    boolean existsByEmail(String email);

    Optional<Candidat> findByEmail(String email);
}
