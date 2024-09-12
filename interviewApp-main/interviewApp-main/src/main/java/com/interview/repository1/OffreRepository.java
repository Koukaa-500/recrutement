package com.interview.repository1;

import com.interview.model.Entity1.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OffreRepository extends JpaRepository<Offre,Integer> {
}
