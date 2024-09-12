package com.interview.serviceBachka.impl;

import com.interview.model.Entity1.*;
import com.interview.repository1.*;
import com.interview.serviceBachka.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UtilisateurServiceImplementation implements UtilisateurService {
    private final CandidatureRepository candidatureRepository;
    private final AdministrateurRepository administrateurRepository;
    private final CandidatRepository candidatRepository;
    private final RecruteurRepository recruteurRepository;


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
    public Optional<Recruteur> modifyRecruteur(Recruteur recruteur) {
        if (recruteur.getId() == null || !recruteurRepository.existsById(recruteur.getId())) {
            return Optional.empty(); // Return empty if the recruteur does not exist
        }
        Recruteur updatedRecruteur = recruteurRepository.save(recruteur);
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
    public Optional<Administrateur> modifyAdministrateur(Administrateur administrateur) {
        if (administrateur.getId() == null || !administrateurRepository.existsById(administrateur.getId())) {
            return Optional.empty(); // Return empty if the administrateur does not exist
        }
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
    public Optional<Candidat> modifyCandidat(Candidat candidat) {
        if (candidat.getId() == null || !candidatRepository.existsById(candidat.getId())) {
            return Optional.empty(); // Return empty if the candidat does not exist
        }
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


    @Override
    public Optional<List<Candidat>> getCandidatByRecruteurOffre(Integer recruteur) {

      List<Candidature> list=  candidatureRepository.findAll();
        Optional<List<Candidat>> listCandidat = Optional.of(Collections.emptyList());
        for (Candidature c:list
             ) {
            if(c.getOffre().getRecruteur().getId().equals(recruteur)){
                listCandidat.get().add(c.getCandidat());
            }

        }

        return listCandidat;
    }


}
