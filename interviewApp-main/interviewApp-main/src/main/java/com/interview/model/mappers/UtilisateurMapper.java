package com.interview.model.mappers;

import org.modelmapper.ModelMapper;

import com.interview.model.dto.UtilisateurDto;
import com.interview.model.entity.Utilisateur;



public class UtilisateurMapper {
	private static final ModelMapper modelMapper= new ModelMapper();
	public static UtilisateurDto convertToDTO(Utilisateur user)
	{
	return modelMapper.map(user, UtilisateurDto.class);
	}

	public static Utilisateur convertToEntity(UtilisateurDto userDTO)
	{
	return modelMapper.map(userDTO, Utilisateur.class);	
	}

}
