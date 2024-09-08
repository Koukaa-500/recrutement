package com.interview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.model.entity.Test;

public interface TestRepository extends JpaRepository<Test, Long> {

}
