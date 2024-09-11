package com.interview.ControllerBachka;


import com.interview.model.EntityBachka.Candidat;
import com.interview.serviceBachka.UtilisateurService;
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
    @PutMapping
    public ResponseEntity<Candidat> modifyCandidat(@RequestBody Candidat candidat) {
        Optional<Candidat> updatedCandidat = utilisateurService.modifyCandidat(candidat);
        return updatedCandidat
                .map(candidat1 -> ResponseEntity.ok().body(candidat1))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidatById(@PathVariable Integer id) {
        boolean isDeleted = utilisateurService.deleteCandidatById(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}