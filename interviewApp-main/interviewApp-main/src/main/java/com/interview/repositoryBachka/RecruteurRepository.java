package com.interview.repositoryBachka;

import com.interview.model.EntityBachka.Recruteur;
import com.interview.model.EntityBachka.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RecruteurRepository extends JpaRepository<Recruteur, Integer> {

    boolean existsByEmail(String email);

    Optional<Recruteur> findByEmail(String email);
}
