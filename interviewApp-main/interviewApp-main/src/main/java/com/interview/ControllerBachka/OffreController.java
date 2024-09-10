package com.interview.ControllerBachka;

import com.interview.serviceBachka.OffreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.interview.model.DTOBachka.OffreDto;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("offre")
public class OffreController {
	private final OffreService offreService;
	@PostMapping("/ajout")
	public ResponseEntity<OffreDto> ajouterOffre(@RequestBody OffreDto offre)

	{
		return ResponseEntity.ok(offreService.ajouterOffre(offre));
	}
	@PutMapping
	public ResponseEntity<OffreDto> modifierOffre(@RequestBody OffreDto offre)
	{
		return ResponseEntity.ok(offreService.ModifierOffre(offre));
	}
	@GetMapping("/all")
	public ResponseEntity<List<OffreDto>> getAllOffres(@PathVariable long id)
	{
		return ResponseEntity.ok(offreService.getAllOffre());
	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable Integer id )
	{
		offreService.SupprimerOffre(id);
	}

}
