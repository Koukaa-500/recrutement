package com.interview.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.interview.model.dto.OffreDto;
import com.interview.model.entity.Offre;
import com.interview.model.entity.Utilisateur;
import com.interview.model.mappers.OffreMapper;
import com.interview.repositories.OffreRepository;
import com.interview.repositories.UtilisateurRepository;
import com.interview.services.OffreService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class OffreServiceImp implements OffreService {
	
	private final OffreRepository offreRepository;
	private final UtilisateurRepository utilisateurRepository;

	@Override
	public OffreDto addOneOffre(OffreDto offre, long idRecruteur) {
		// TODO Auto-generated method stub
		Offre ofr=OffreMapper.convertToEntity(offre);
		Utilisateur recruteur=utilisateurRepository.findById(idRecruteur).orElse(null);
		if(recruteur!=null)
		{
			ofr.setRecruteur(recruteur);
			return OffreMapper.convertToDTO(offreRepository.save(ofr));
			
		}
		else
		return null;
	}

	@Override
	public Page<OffreDto> getOffres(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Offre> offres=offreRepository.findAll(pageable);
		
		return offres.map(OffreMapper::convertToDTO);
	}

	@Override
	public OffreDto getOneOffre(long id) {
		// TODO Auto-generated method stub
		return OffreMapper.convertToDTO(offreRepository.findById(id).orElse(null));
	}

	@Override
	public void deleteOneOffre(long id) {
		// TODO Auto-generated method stub
		offreRepository.deleteById(id);

	}

}
