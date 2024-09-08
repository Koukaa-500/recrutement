package com.interview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.model.entity.Utilisateur;
import java.util.List;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
Utilisateur findByEmail(String email);
}
