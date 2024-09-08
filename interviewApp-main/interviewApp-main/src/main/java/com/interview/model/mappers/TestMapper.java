package com.interview.model.mappers;

import org.modelmapper.ModelMapper;

import com.interview.model.dto.TestDto;
import com.interview.model.entity.Test;

public class TestMapper {
	private static final ModelMapper modelMapper= new ModelMapper();
	public static TestDto convertToDTO(Test test)
	{
	return modelMapper.map(test, TestDto.class);
	}

	public static Test convertToEntity(TestDto testDTO)
	{
	return modelMapper.map(testDTO, Test.class);	
	}

}
