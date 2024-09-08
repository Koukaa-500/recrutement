package com.interview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.model.entity.Offre;

public interface OffreRepository extends JpaRepository<Offre, Long> {

}
