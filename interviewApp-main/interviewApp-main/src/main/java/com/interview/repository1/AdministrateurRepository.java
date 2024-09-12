package com.interview.repository1;

import com.interview.model.Entity1.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface AdministrateurRepository extends JpaRepository<Administrateur,Integer> {
    boolean existsByEmail(String email);

    Optional<Administrateur> findByEmail(String email);
}
