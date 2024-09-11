package com.interview.repositoryBachka;

import com.interview.model.EntityBachka.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministrateurRepository extends JpaRepository<Administrateur,Integer> {
    boolean existsByEmail(String email);

    Optional<Administrateur> findByEmail(String email);
}
