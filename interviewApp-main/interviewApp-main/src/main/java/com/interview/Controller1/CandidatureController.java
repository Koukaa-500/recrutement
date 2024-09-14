package com.interview.Controller1;

import com.interview.model.DTO1.CandidatDto;
import com.interview.model.DTO1.CandidatureDto;
import com.interview.model.Entity1.Enum.CandidatureStatus;
import com.interview.service1.CandidatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("candidature")
public class CandidatureController {
    private final CandidatureService candidatureService;
    @PostMapping("/postuler/{condidatId}/{offreId}")
    public ResponseEntity<CandidatureDto> postuler(@PathVariable Integer condidatId, @PathVariable Integer offreId)

    {
        return ResponseEntity.ok(candidatureService.postuler(condidatId , offreId));
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<List<CandidatureDto>> getAllCandidaturebyCandidat(@PathVariable Integer id)
//    {
//        return ResponseEntity.ok(candidatureService.getAllCandidaturebyCandidat(id));
//    }
//    // Endpoint to change the status of a candidature
    @PutMapping("/status/{status}")
    public CandidatureDto changeCandidatureStatus(@RequestBody CandidatureDto candidatureDto, @PathVariable CandidatureStatus status) {
        return candidatureService.changeCandidatureStatus(candidatureDto, status);
    }

//    // Endpoint to delete a candidature
//    @DeleteMapping("/delete")
//    public Boolean supprimerCandidature(@RequestBody CandidatureDto candidatureDto) {
//        return candidatureService.supprimerCandidature(candidatureDto);
//    }

    @GetMapping("/cand/{id}")
    public ResponseEntity<CandidatureDto> getCandidatureDetails(@PathVariable Integer id) {
        CandidatureDto detailedCandidatureDto = candidatureService.getCandidatureDetails(id);
        return ResponseEntity.ok(detailedCandidatureDto);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<CandidatureDto>> getAllCandidatures() {
        List<CandidatureDto> detailedCandidatureDto = candidatureService.getall();
        return ResponseEntity.ok(detailedCandidatureDto);
    }

    @GetMapping("/candidature/{jobid}")
    public ResponseEntity<CandidatureDto> getCandidatureJobDetails(@PathVariable Integer jobId) {
        CandidatureDto detailedCandidatureDto = candidatureService.getCandidatureDetails(jobId);
        return ResponseEntity.ok(detailedCandidatureDto);
    }
}
