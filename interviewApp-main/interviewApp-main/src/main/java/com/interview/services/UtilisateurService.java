package com.interview.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.interview.model.dto.ProfileDto;
import com.interview.model.dto.UtilisateurDto;
import com.interview.model.entity.Profile;

public interface UtilisateurService {
public UtilisateurDto addOneUtilisateur(UtilisateurDto utilisateurDto);
public Page<UtilisateurDto> getAllUtilisateur(Pageable pageable );
public Optional<UtilisateurDto> getOneUtilisateur(long id);
public void deleteOneUtilisateur(long id);
public ProfileDto assignProfileToUtilisateur(long idUser,Profile ProfileDto);
public UtilisateurDto findByEmail(String email);


}
