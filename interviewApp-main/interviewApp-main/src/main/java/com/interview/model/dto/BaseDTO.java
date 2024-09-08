package com.interview.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BaseDTO {
	private int id;
	private LocalDateTime createdAt;
	private LocalDateTime updateAt;

}
