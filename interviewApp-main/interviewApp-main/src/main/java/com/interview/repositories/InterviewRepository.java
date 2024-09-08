package com.interview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.model.entity.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Long> {

}
