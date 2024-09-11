package com.interview.repositoryBachka;

import com.interview.model.EntityBachka.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterviewRepository extends JpaRepository<Interview,Integer> {
    @Override
    Optional<Interview> findById(Integer integer);
}
