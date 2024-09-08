package com.interview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.model.entity.Candidature;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {

}
