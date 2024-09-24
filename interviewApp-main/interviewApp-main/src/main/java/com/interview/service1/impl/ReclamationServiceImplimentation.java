package com.interview.service1.impl;

import com.interview.model.Entity1.Reclamation;
import com.interview.repository1.ReclamationRepository;
import com.interview.repository1.CandidatRepository;
import com.interview.service1.ReclamationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamationServiceImplimentation implements ReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    // Candidate submits reclamation
    @Override
    public Reclamation submitReclamation(Integer candidatId, Integer jobId, String content) {
        var candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new EntityNotFoundException("Candidat not found"));

        // Check for existing reclamation
        Optional<Reclamation> existingReclamation = findExistingReclamation(candidatId, jobId);
        if (existingReclamation.isPresent()) {
            return existingReclamation.get(); // Return the existing reclamation if found
        }

        Reclamation reclamation = new Reclamation();
        reclamation.setCandidat(candidat);
        reclamation.setJobId(jobId);
        reclamation.setContent(content);
        reclamation.setStatus("Pending");

        return reclamationRepository.save(reclamation);
    }


    // Candidate views their reclamations
    @Override
    public List<Reclamation> getReclamationsByCandidat(Integer candidatId) {
        var candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new EntityNotFoundException("Candidat not found"));
        return reclamationRepository.findByCandidat(candidat);
    }

    @Override
    public Optional<Reclamation> getReclamationById(Integer id) {
        return reclamationRepository.findById(id);
    }

    // Admin views all reclamations
    @Override
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    // Admin responds to reclamation
    @Override
    public Optional<Reclamation> respondToReclamation(Integer id, String response) {
        return reclamationRepository.findById(id)
                .map(reclamation -> {
                    reclamation.setResponse(response);
                    reclamation.setIsResponded(true);
                    reclamation.setStatus("Opened"); // Update status if necessary
                    return reclamationRepository.save(reclamation);
                });
    }
    @Override
    public Optional<Reclamation> findExistingReclamation(Integer candidatId, Integer jobId) {
        return reclamationRepository.findByCandidatIdAndJobId(candidatId, jobId);
    }

    @Override
    public boolean deleteReclamation(Integer id) {
        if (reclamationRepository.existsById(id)) {
            reclamationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

