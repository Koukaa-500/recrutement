package com.interview.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.model.dto.ProfileDto;
import com.interview.model.dto.UtilisateurDto;
import com.interview.model.mappers.ProfileMapper;
import com.interview.services.UtilisateurService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/utilisateur")
@RequiredArgsConstructor
public class 	UtilisateurController {
	private final UtilisateurService utilisateurService;
	@PostMapping
	public ResponseEntity<UtilisateurDto> addOneUser(@RequestBody UtilisateurDto utilisateur)
	
	{
		return ResponseEntity.ok(utilisateurService.addOneUtilisateur(utilisateur));
	}
	@GetMapping
	public ResponseEntity<Page<UtilisateurDto>> getUsers(Pageable pageable)
	{
		return ResponseEntity.ok(utilisateurService.getAllUtilisateur(pageable));
	}
	@GetMapping("/{id}")
	public ResponseEntity<UtilisateurDto> getOneUtilisateur(@PathVariable long id)
	{
		return ResponseEntity.ok(utilisateurService.getOneUtilisateur(id).orElse(null));
	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable long id )
	{
		utilisateurService.deleteOneUtilisateur(id);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ProfileDto> assignProfil(@PathVariable long id,@RequestBody ProfileDto profile)
	{
		return ResponseEntity.ok(utilisateurService.assignProfileToUtilisateur(id, ProfileMapper.convertToEntity(profile)));
		
	}
	@GetMapping("/email/{email}")
	public ResponseEntity<UtilisateurDto> getByEmail(@PathVariable String email)
	{
		return ResponseEntity.ok(utilisateurService.findByEmail(email));
	}
	
	
	
	

}
