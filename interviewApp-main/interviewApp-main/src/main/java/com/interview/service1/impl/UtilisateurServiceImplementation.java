package com.interview.service1.impl;

import com.interview.model.Entity1.*;
import com.interview.repository1.*;
import com.interview.service1.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UtilisateurServiceImplementation implements UtilisateurService {
    private final CandidatureRepository candidatureRepository;
    private final AdministrateurRepository administrateurRepository;
    private final CandidatRepository candidatRepository;
    private final RecruteurRepository recruteurRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<Recruteur> getRecruteurByEmail(String email) {
        return recruteurRepository.findByEmail(email);
    }

    @Override
    public List<Recruteur> getAllRecruteurs() {
        return recruteurRepository.findAll();
    }

    @Override
    public Optional<Administrateur> getAdministrateurByEmail(String email) {
        return administrateurRepository.findByEmail(email);
    }

    @Override
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }


    @Override
    public Optional<Candidat> getCandidatByEmail(String email) {
        return candidatRepository.findByEmail(email);
    }

    @Override
    public List<Candidat> getAllCandidats() {
        return candidatRepository.findAll();
    }

    @Override
    public Optional<Recruteur> modifyRecruteur(Integer id, Recruteur recruteur) {
        String encodedPassword = passwordEncoder.encode(recruteur.getMotDePasse());
        // Check if a Recruteur with the given id exists
        if (!recruteurRepository.existsById(id)) {
            return Optional.empty(); // Return empty if the Recruteur does not exist
        }

        // Retrieve the existing Recruteur
        Recruteur existingRecruteur = recruteurRepository.findById(id).get();

        // Update fields
        existingRecruteur.setNom(recruteur.getNom());
        existingRecruteur.setPrenom(recruteur.getPrenom());
        existingRecruteur.setAge(recruteur.getAge());

        // Update password if provided
        if (recruteur.getMotDePasse() != null && !recruteur.getMotDePasse().isEmpty()) {

            existingRecruteur.setMotDePasse(encodedPassword);
        }

        // Save the updated Recruteur object
        Recruteur updatedRecruteur = recruteurRepository.save(existingRecruteur);

        return Optional.of(updatedRecruteur);
}



    @Override
    public boolean deleteRecruteurById(Integer id) {
        if (recruteurRepository.existsById(id)) {
            recruteurRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Administrateur> modifyAdministrateur(Integer id, Administrateur administrateur) {
        // Check if an Administrateur with the given id exists
        if (!administrateurRepository.existsById(id)) {
            return Optional.empty(); // Return empty if the Administrateur does not exist
        }

        // Set the id of the administrateur object to the id provided in the URL
        administrateur.setId(id);

        // Encrypt the password if it's provided
        if (administrateur.getMotDePasse() != null) {
            administrateur.setMotDePasse(passwordEncoder.encode(administrateur.getMotDePasse()));
        }

        // Save the updated Administrateur object
        Administrateur updatedAdministrateur = administrateurRepository.save(administrateur);

        return Optional.of(updatedAdministrateur);
    }



    @Override
    public boolean deleteAdministrateurById(Integer id) {
        if (administrateurRepository.existsById(id)) {
            administrateurRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Candidat> modifyCandidat(Integer id, Candidat candidat) {
        // Check if a Candidat with the given id exists
        if (!candidatRepository.existsById(id)) {
            return Optional.empty(); // Return empty if the Candidat does not exist
        }

        // Set the id of the candidat object to the id provided in the URL
        candidat.setId(id);

        // Encrypt the password if it's provided
        if (candidat.getMotDePasse() != null) {
            candidat.setMotDePasse(passwordEncoder.encode(candidat.getMotDePasse()));
        }

        // Save the updated Candidat object
        Candidat updatedCandidat = candidatRepository.save(candidat);

        return Optional.of(updatedCandidat);
    }



    @Override
    public boolean deleteCandidatById(Integer id) {
        if (candidatRepository.existsById(id)) {
            candidatRepository.deleteById(id);
            return true;
        }
        return false;
    }


//    @Override
//    public Optional<List<Candidat>> getCandidatByRecruteurOffre(Integer recruteur) {
//
//      List<Candidature> list=  candidatureRepository.findAll();
//        Optional<List<Candidat>> listCandidat = Optional.of(Collections.emptyList());
//        for (Candidature c:list
//             ) {
//            if(c.getOffre().getRecruteur().getId().equals(recruteur)){
//                listCandidat.get().add(c.getCandidat());
//            }
//
//        }
//
//        return listCandidat;
//    }


}
