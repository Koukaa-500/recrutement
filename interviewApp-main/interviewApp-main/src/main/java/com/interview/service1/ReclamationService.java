package com.interview.service1;

import com.interview.model.Entity1.Reclamation;
import java.util.List;
import java.util.Optional;

public interface ReclamationService {

    // Candidate methods
    Reclamation submitReclamation(Integer candidatId, Integer jobId, String content);
    List<Reclamation> getReclamationsByCandidat(Integer candidatId);

    // Admin methods
    List<Reclamation> getAllReclamations();
    Optional<Reclamation> respondToReclamation(Integer id, String response);
    Optional<Reclamation> getReclamationById(Integer id);

    Optional<Reclamation> findExistingReclamation(Integer candidatId, Integer jobId);

    boolean deleteReclamation(Integer id);
}
