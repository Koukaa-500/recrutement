package com.interview.ControllerBachka;

import com.interview.model.EntityBachka.Administrateur;
import com.interview.serviceBachka.UtilisateurService;
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

    @PutMapping
    public ResponseEntity<Administrateur> modifyAdministrateur(@RequestBody Administrateur administrateur) {
        Optional<Administrateur> updatedAdministrateur = utilisateurService.modifyAdministrateur(administrateur);
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