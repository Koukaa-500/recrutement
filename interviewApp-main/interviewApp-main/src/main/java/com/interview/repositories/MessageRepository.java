package com.interview.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interview.model.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
