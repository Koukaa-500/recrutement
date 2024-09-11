package com.interview.repositoryBachka;

import com.interview.model.EntityBachka.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface AdministrateurRepository extends JpaRepository<Administrateur,Integer> {
    boolean existsByEmail(String email);

    Optional<Administrateur> findByEmail(String email);
}
