package com.interview.Controller1;

import com.interview.model.Entity1.Recruteur;
import com.interview.service1.UtilisateurService;
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
    @PutMapping("/{id}")
    public ResponseEntity<Recruteur> modifyRecruteur(@PathVariable Integer id, @RequestBody Recruteur recruteur) {
        // Call the service with the id and the updated Recruteur object
        Optional<Recruteur> updatedRecruteur = utilisateurService.modifyRecruteur(id, recruteur);

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
