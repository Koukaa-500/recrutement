package com.interview.Controller1;


import com.interview.model.Entity1.Candidat;
import com.interview.model.Entity1.Reclamation;
import com.interview.service1.UtilisateurService;
import com.interview.service1.ReclamationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidats")
@RequiredArgsConstructor
public class CandidatController {

    private final UtilisateurService utilisateurService;

    @GetMapping("/{email}")
    public ResponseEntity<Candidat> getCandidatByEmail(@PathVariable String email) {
        return utilisateurService.getCandidatByEmail(email)
                .map(candidat -> ResponseEntity.ok().body(candidat))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Candidat>> getAllCandidats() {
        List<Candidat> candidats = utilisateurService.getAllCandidats();
        return ResponseEntity.ok().body(candidats);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Candidat> modifyCandidat(@PathVariable Integer id, @RequestBody Candidat candidat) {
        // Call the service with the ID and the updated Candidat object
        Optional<Candidat> updatedCandidat = utilisateurService.modifyCandidat(id, candidat);

        return updatedCandidat
                .map(candidat1 -> ResponseEntity.ok().body(candidat1))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidatById(@PathVariable Integer id) {
        boolean isDeleted = utilisateurService.deleteCandidatById(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

//    @GetMapping("/all/{recruterId}")
//    public ResponseEntity<List<Candidat>> getCandidatByRecruteurOffre(@PathVariable Integer recruterId) {
//      return ResponseEntity.ok().body( utilisateurService.getCandidatByRecruteurOffre(recruterId).get());
//    }

}