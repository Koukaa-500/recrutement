package com.interview.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.interview.model.dto.ProfileDto;
import com.interview.model.dto.UtilisateurDto;
import com.interview.model.entity.Profile;
import com.interview.model.entity.Utilisateur;
import com.interview.model.mappers.ProfileMapper;
import com.interview.model.mappers.UtilisateurMapper;
import com.interview.repositories.ProfilRepository;
import com.interview.repositories.UtilisateurRepository;
import com.interview.services.UtilisateurService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UtilisateurServiceImplement implements UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;
	private final ProfilRepository profilRepository;
	
	
	
	@Override
	public UtilisateurDto addOneUtilisateur(UtilisateurDto utilisateurDto) {
		// TODO Auto-generated method stub
		Utilisateur us= utilisateurRepository.save(UtilisateurMapper.convertToEntity(utilisateurDto));
		
		return utilisateurDto;
	}

	@Override
	public Page<UtilisateurDto> getAllUtilisateur(Pageable pageable) {
	    Page<Utilisateur> utilisateurs = utilisateurRepository.findAll(pageable);
	    
	    return utilisateurs.map(UtilisateurMapper::convertToDTO);
	}


	@Override
	public Optional<UtilisateurDto> getOneUtilisateur(long id) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findById(id).map(UtilisateurMapper::convertToDTO);
	}

	@Override
	public void deleteOneUtilisateur(long id) {
		// TODO Auto-generated method stub
		utilisateurRepository.deleteById(id);

	}

	@Override
	public ProfileDto assignProfileToUtilisateur(long idUser, Profile profile) {
		// TODO Auto-generated method stub
		
			Utilisateur utilisateur=utilisateurRepository.findById(idUser).orElse(null);
			if(utilisateur!=null)
			{
			utilisateur.setProfile(profile);
			
			utilisateurRepository.save(utilisateur);
			return ProfileMapper.convertToDTO(profile);
			}
			
		
		
		return null;
	}

	@Override
	public UtilisateurDto findByEmail(String email) {
		// TODO Auto-generated method stub
		return UtilisateurMapper.convertToDTO(utilisateurRepository.findByEmail(email));
	}

}
