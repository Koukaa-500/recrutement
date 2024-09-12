package com.interview.model.mappers;

import org.modelmapper.ModelMapper;

import com.interview.model.DTO1.InterviewDto;
import com.interview.model.Entity1.Interview;

public class InterviewMapper {
	private static final ModelMapper modelMapper= new ModelMapper();
	public static InterviewDto convertToDTO(Interview interview)
	{
	return modelMapper.map(interview, InterviewDto.class);
	}

	public static Interview convertToEntity(InterviewDto interviewDTO)
	{
	return modelMapper.map(interviewDTO, Interview.class);
	}

}
