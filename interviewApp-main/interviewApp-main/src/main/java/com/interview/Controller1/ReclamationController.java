package com.interview.Controller1;

import com.interview.model.DTO1.ReclamationDto;
import com.interview.model.Entity1.Reclamation;
import com.interview.service1.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/reclamations")
public class ReclamationController {

    @Autowired
    private ReclamationService reclamationService; // Inject the service

    @PostMapping("/candidat")
    public ResponseEntity<Reclamation> submitReclamation(@RequestBody ReclamationDto request) {
        Reclamation reclamation = reclamationService.submitReclamation(request.getCandidatId(), request.getJobId(), request.getContent());
        return ResponseEntity.ok(reclamation);
    }


    @GetMapping("/{candidatId}")
    public ResponseEntity<List<Reclamation>> getReclamationsByCandidat(@PathVariable Integer candidatId) {
        List<Reclamation> reclamations = reclamationService.getReclamationsByCandidat(candidatId);
        return ResponseEntity.ok(reclamations);
    }
}
