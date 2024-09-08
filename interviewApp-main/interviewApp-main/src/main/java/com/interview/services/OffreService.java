package com.interview.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.interview.model.dto.OffreDto;

public interface OffreService {
	public OffreDto addOneOffre(OffreDto offre,long idRecruteur);
	public Page<OffreDto> getOffres(Pageable pageable);
	public OffreDto getOneOffre(long id);
	public void deleteOneOffre(long id);

}
