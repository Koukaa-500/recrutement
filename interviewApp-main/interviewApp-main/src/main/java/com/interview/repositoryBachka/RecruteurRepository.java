package com.interview.repositoryBachka;

import com.interview.model.EntityBachka.Recruteur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruteurRepository extends JpaRepository<Recruteur, Integer> {

}
