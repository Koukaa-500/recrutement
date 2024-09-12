package com.interview.model.mappers;

import com.interview.model.DTO1.OffreDto;
import com.interview.model.Entity1.Offre;
import com.interview.model.Entity1.Recruteur;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class OffreMapper {

	private static final ModelMapper modelMapper = new ModelMapper();

	static {
		// Custom mapping from Offre to OffreDto
		modelMapper.addMappings(new PropertyMap<Offre, OffreDto>() {
			@Override
			protected void configure() {
				map(source.getRecruteur().getId(), destination.getRecruteur());  // Map recruteur id
			}
		});

		// Custom mapping from OffreDto to Offre
		modelMapper.addMappings(new PropertyMap<OffreDto, Offre>() {
			@Override
			protected void configure() {
				skip(destination.getRecruteur());  // Skip the automatic mapping for Recruteur
			}
		});
	}

	// Convert from Entity to DTO
	public static OffreDto convertToDTO(Offre offre) {
		return modelMapper.map(offre, OffreDto.class);
	}

	// Convert from DTO to Entity
	public static Offre convertToEntity(OffreDto offreDTO, Recruteur recruteur) {
		Offre offre = modelMapper.map(offreDTO, Offre.class);
		offre.setRecruteur(recruteur);  // Set the Recruteur entity based on the DTO's recruteur id
		return offre;
	}
}
