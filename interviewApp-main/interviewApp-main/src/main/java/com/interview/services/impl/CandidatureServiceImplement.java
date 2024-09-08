package com.interview.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.interview.model.dto.CandidatureDto;
import com.interview.model.entity.Candidature;
import com.interview.model.entity.Utilisateur;
import com.interview.model.mappers.CandidatureMapper;
import com.interview.repositories.CandidatureRepository;
import com.interview.repositories.UtilisateurRepository;
import com.interview.services.CandidatureService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CandidatureServiceImplement implements CandidatureService {

	private final CandidatureRepository candidatureRepository;
	private final UtilisateurRepository utilisateurRepository;

	@Override
	public CandidatureDto addOneCandidature(CandidatureDto candidature, long idCandidat) {
		// TODO Auto-generated method stub
		Candidature ofr=CandidatureMapper.convertToEntity(candidature);
		Utilisateur candidat=utilisateurRepository.findById(idCandidat).orElse(null);
		if(candidat!=null)
		{
			ofr.setEmetteur(candidat);
			return CandidatureMapper.convertToDTO(candidatureRepository.save(ofr));
			
		}
		else
		return null;
	}

	@Override
	public Page<CandidatureDto> getCandidatures(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Candidature> candidatures=candidatureRepository.findAll(pageable);
		
		return candidatures.map(CandidatureMapper::convertToDTO);
	}

	@Override
	public CandidatureDto getOneCandidature(long id) {
		// TODO Auto-generated method stub
		return CandidatureMapper.convertToDTO(candidatureRepository.findById(id).orElse(null));
	}

	@Override
	public void deleteOneCandidature(long id) {
		// TODO Auto-generated method stub
		candidatureRepository.deleteById(id);

	}


}
