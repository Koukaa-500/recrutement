package com.interview.model.mappers;

import com.interview.model.DTOBachka.OffreDto;
import com.interview.model.EntityBachka.Offre;
import org.modelmapper.ModelMapper;


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
