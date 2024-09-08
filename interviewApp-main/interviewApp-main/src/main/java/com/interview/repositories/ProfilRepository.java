package com.interview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.model.entity.Profile;

public interface ProfilRepository extends JpaRepository<Profile, Long> {

}
