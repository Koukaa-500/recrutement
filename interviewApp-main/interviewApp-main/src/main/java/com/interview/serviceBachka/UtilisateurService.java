package com.interview.serviceBachka;

import com.interview.model.EntityBachka.*;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    public Optional<Recruteur> getRecruteurByEmail(String email) ;

    public List<Recruteur> getAllRecruteurs() ;
    Optional<Administrateur> getAdministrateurByEmail(String email);
    List<Administrateur> getAllAdministrateurs();
    Optional<Candidat> getCandidatByEmail(String email);
    List<Candidat> getAllCandidats();

    Optional<Recruteur> modifyRecruteur(Recruteur recruteur);

    boolean deleteRecruteurById(Integer id);

    Optional<Administrateur> modifyAdministrateur(Administrateur administrateur);

    boolean deleteAdministrateurById(Integer id);

    Optional<Candidat> modifyCandidat(Candidat candidat);

    boolean deleteCandidatById(Integer id);


    Optional<List<Candidat>> getCandidatByRecruteurOffre(Integer recruteur);
}
