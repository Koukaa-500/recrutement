package com.interview.Controller1;

import com.interview.model.DTO1.CandidatureDto;
import com.interview.model.Entity1.Enum.CandidatureStatus;
import com.interview.serviceBachka.CandidatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("candidature")
public class CandidatureController {
    private final CandidatureService candidatureService;
    @PostMapping("/postuler")
    public ResponseEntity<CandidatureDto> postuler(@RequestBody CandidatureDto candidature)

    {
        return ResponseEntity.ok(candidatureService.postuler(candidature));
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<CandidatureDto>> getAllCandidaturebyCandidat(@PathVariable Integer id)
    {
        return ResponseEntity.ok(candidatureService.getAllCandidaturebyCandidat(id));
    }
    // Endpoint to change the status of a candidature
    @PutMapping("/status")
    public CandidatureDto changeCandidatureStatus(@RequestBody CandidatureDto candidatureDto, @RequestParam CandidatureStatus status) {
        return candidatureService.changeCandidatureStatus(candidatureDto, status);
    }

    // Endpoint to delete a candidature
    @DeleteMapping("/delete")
    public Boolean supprimerCandidature(@RequestBody CandidatureDto candidatureDto) {
        return candidatureService.supprimerCandidature(candidatureDto);
    }
}
