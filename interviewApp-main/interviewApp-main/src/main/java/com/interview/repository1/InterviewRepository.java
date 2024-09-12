package com.interview.repository1;

import com.interview.model.Entity1.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterviewRepository extends JpaRepository<Interview,Integer> {
    @Override
    Optional<Interview> findById(Integer integer);
}
