package com.interview.model.mappers;


import com.interview.model.DTOBachka.CandidatureDto;
import com.interview.model.EntityBachka.Candidature;
import org.modelmapper.ModelMapper;

public class CandidatureMapper {
	private static final ModelMapper modelMapper= new ModelMapper();
	public static CandidatureDto convertToDTO(Candidature candidature)
	{
	return modelMapper.map(candidature, CandidatureDto.class);
	}

	public static Candidature convertToEntity(CandidatureDto candidatureDTO)
	{
	return modelMapper.map(candidatureDTO, Candidature.class);	
	}

}
