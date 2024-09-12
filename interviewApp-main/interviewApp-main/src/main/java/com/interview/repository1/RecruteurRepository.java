package com.interview.repository1;

import com.interview.model.Entity1.Recruteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RecruteurRepository extends JpaRepository<Recruteur, Integer> {

    boolean existsByEmail(String email);

    Optional<Recruteur> findByEmail(String email);
}
