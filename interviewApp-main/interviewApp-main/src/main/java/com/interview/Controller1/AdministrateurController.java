package com.interview.Controller1;

import com.interview.model.Entity1.Administrateur;
import com.interview.service1.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/administrateurs")
@RequiredArgsConstructor
public class AdministrateurController {

    private final UtilisateurService utilisateurService;

    @GetMapping("/{email}")
    public ResponseEntity<Administrateur> getAdministrateurByEmail(@PathVariable String email) {
        return utilisateurService.getAdministrateurByEmail(email)
                .map(administrateur -> ResponseEntity.ok().body(administrateur))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Administrateur>> getAllAdministrateurs() {
        List<Administrateur> administrateurs = utilisateurService.getAllAdministrateurs();
        return ResponseEntity.ok().body(administrateurs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrateur> modifyAdministrateur(@PathVariable Integer id, @RequestBody Administrateur administrateur) {
        // Call the service with the id and the updated Administrateur object
        Optional<Administrateur> updatedAdministrateur = utilisateurService.modifyAdministrateur(id, administrateur);

        return updatedAdministrateur
                .map(administrateur1 -> ResponseEntity.ok().body(administrateur1))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrateurById(@PathVariable Integer id) {
        boolean isDeleted = utilisateurService.deleteAdministrateurById(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}