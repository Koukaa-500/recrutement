package com.interview.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.model.dto.OffreDto;
import com.interview.services.OffreService;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping("offre")
public class OffreController {
	private final OffreService offreService;
	@PostMapping("/{id}")
	public ResponseEntity<OffreDto> addOneUser(@RequestBody OffreDto offre, @PathVariable long idCandidat)
	
	{
		return ResponseEntity.ok(offreService.addOneOffre(offre,idCandidat));
	}
	@GetMapping
	public ResponseEntity<Page<OffreDto>> getUsers(Pageable pageable)
	{
		return ResponseEntity.ok(offreService.getOffres(pageable));
	}
	@GetMapping("/{id}")
	public ResponseEntity<OffreDto> getOneOffre(@PathVariable long id)
	{
		return ResponseEntity.ok(offreService.getOneOffre(id));
	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable long id )
	{
		offreService.deleteOneOffre(id);
	}

}
