package com.interview.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
@Column(updatable = false,nullable = false)
private LocalDateTime createdAt;
@Column(nullable = false)
private LocalDateTime updateAt;
@PrePersist 
public void init()
{
createdAt=updateAt=LocalDateTime.now();	
}
@PreUpdate
public void preUpdate()
{
updateAt=LocalDateTime.now();	
}



}
