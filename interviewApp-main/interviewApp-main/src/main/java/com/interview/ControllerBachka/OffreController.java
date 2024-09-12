package com.interview.ControllerBachka;

import com.interview.model.EntityBachka.Enum.OffreStatus;
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
	@PutMapping("/modify")
	public ResponseEntity<OffreDto> modifierOffre(@RequestBody OffreDto offre)
	{
		return ResponseEntity.ok(offreService.ModifierOffre(offre));
	}
	@GetMapping("/all")
	public ResponseEntity<List<OffreDto>> getAllOffres()
	{
		return ResponseEntity.ok(offreService.getAllOffre());
	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable Integer id )
	{
		offreService.SupprimerOffre(id);
	}

	@PutMapping("/{status}")
	public void changeStatus(@RequestBody OffreDto offreDto,@PathVariable OffreStatus status )
	{
		offreService.setOffreStatus(offreDto,status);
	}
	@GetMapping("/count")
	public Long getNumberofAllOffers() {
		return offreService.getNumberofAllOffers();
	}

	// Endpoint to get the number of candidates for a specific offer
	@PostMapping("/candidates/count")
	public Integer getNumberOfCandidatesPerOffer(@RequestBody OffreDto offreDto) {
		return offreService.getNumberOfCandidatesPerOffer(offreDto);
	}

}
