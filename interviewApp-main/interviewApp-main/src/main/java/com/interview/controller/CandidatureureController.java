package com.interview.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.model.dto.CandidatureDto;
import com.interview.model.dto.ProfileDto;
import com.interview.model.mappers.ProfileMapper;
import com.interview.services.CandidatureService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("candidature")
public class CandidatureureController {
	private final CandidatureService candidatureService;
	@PostMapping("/{id}")
	public ResponseEntity<CandidatureDto> addOneUser(@RequestBody CandidatureDto candidature, @PathVariable long idCandidat)
	
	{
		return ResponseEntity.ok(candidatureService.addOneCandidature(candidature,idCandidat));
	}
	@GetMapping
	public ResponseEntity<Page<CandidatureDto>> getUsers(Pageable pageable)
	{
		return ResponseEntity.ok(candidatureService.getCandidatures(pageable));
	}
	@GetMapping("/{id}")
	public ResponseEntity<CandidatureDto> getOneCandidature(@PathVariable long id)
	{
		return ResponseEntity.ok(candidatureService.getOneCandidature(id));
	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable long id )
	{
		candidatureService.deleteOneCandidature(id);
	}

	

}
