package com.interview.Controller1;

import com.interview.model.DTO1.ReclamationDto;
import com.interview.model.Entity1.Reclamation;
import com.interview.service1.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/admin")
    public ResponseEntity<List<Reclamation>> getAllReclamations() {
        List<Reclamation> reclamations = reclamationService.getAllReclamations();
        return ResponseEntity.ok(reclamations);
    }

    // Respond to a specific reclamation
    @PostMapping("/{id}")
    public ResponseEntity<Reclamation> respondToReclamation(
            @PathVariable Integer id,
            @RequestBody Map<String, String> body) {
        String responseText = body.get("response");
        Optional<Reclamation> updatedReclamation = reclamationService.respondToReclamation(id, responseText);
        return updatedReclamation
                .map(reclamation -> ResponseEntity.ok(reclamation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<Reclamation> getReclamationById(@PathVariable Integer id) {
        return reclamationService.getReclamationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReclamationById(@PathVariable Integer id) {
        boolean isDeleted = reclamationService.deleteReclamation(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
