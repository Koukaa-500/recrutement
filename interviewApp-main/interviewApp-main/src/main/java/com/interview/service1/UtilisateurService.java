package com.interview.service1;

import com.interview.model.Entity1.*;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    public Optional<Recruteur> getRecruteurByEmail(String email) ;

    public List<Recruteur> getAllRecruteurs() ;
    Optional<Administrateur> getAdministrateurByEmail(String email);
    List<Administrateur> getAllAdministrateurs();
    Optional<Candidat> getCandidatByEmail(String email);
    List<Candidat> getAllCandidats();



    Optional<Recruteur> modifyRecruteur(Integer id, Recruteur recruteur);

    boolean deleteRecruteurById(Integer id);


    Optional<Administrateur> modifyAdministrateur(Integer id, Administrateur administrateur);

    boolean deleteAdministrateurById(Integer id);





    Optional<Candidat> modifyCandidat(Integer id, Candidat candidat);

    boolean deleteCandidatById(Integer id);


//    Optional<List<Candidat>> getCandidatByRecruteurOffre(Integer recruteur);
}
