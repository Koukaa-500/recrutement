package com.interview.ControllerBachka;

import com.interview.model.EntityBachka.Recruteur;
import com.interview.serviceBachka.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recruteurs")
@RequiredArgsConstructor
public class RecruteurController {


        private final UtilisateurService utilisateurService;

        @GetMapping("/{email}")
        public ResponseEntity<Recruteur> getRecruteurByEmail(@PathVariable String email) {
            return utilisateurService.getRecruteurByEmail(email)
                    .map(recruteur -> ResponseEntity.ok().body(recruteur))
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @GetMapping
        public ResponseEntity<List<Recruteur>> getAllRecruteurs() {
            List<Recruteur> recruteurs = utilisateurService.getAllRecruteurs();
            return ResponseEntity.ok().body(recruteurs);
        }
    @PutMapping
    public ResponseEntity<Recruteur> modifyRecruteur(@RequestBody Recruteur recruteur) {
        Optional<Recruteur> updatedRecruteur = utilisateurService.modifyRecruteur(recruteur);
        return updatedRecruteur
                .map(recruteur1 -> ResponseEntity.ok().body(recruteur1))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecruteurById(@PathVariable Integer id) {
        boolean isDeleted = utilisateurService.deleteRecruteurById(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
