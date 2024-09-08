package com.interview.model.mappers;

import org.modelmapper.ModelMapper;

import com.interview.model.dto.OffreDto;
import com.interview.model.entity.Offre;

public class OffreMapper {
	private static final ModelMapper modelMapper= new ModelMapper();
	public static OffreDto convertToDTO(Offre offre)
	{
	return modelMapper.map(offre, OffreDto.class);
	}

	public static Offre convertToEntity(OffreDto offreDTO)
	{
	return modelMapper.map(offreDTO, Offre.class);	
	}

}
