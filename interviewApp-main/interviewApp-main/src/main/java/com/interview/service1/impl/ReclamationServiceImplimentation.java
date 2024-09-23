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

        Reclamation reclamation = new Reclamation();
        reclamation.setCandidat(candidat);
        reclamation.setJobId(jobId); // Set jobId directly
        reclamation.setContent(content);
        reclamation.setStatus("OPEN");

        return reclamationRepository.save(reclamation);
    }

    // Candidate views their reclamations
    @Override
    public List<Reclamation> getReclamationsByCandidat(Integer candidatId) {
        var candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new EntityNotFoundException("Candidat not found"));
        return reclamationRepository.findByCandidat(candidat);
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
                    reclamation.setStatus("CLOSED"); // Update status if necessary
                    return reclamationRepository.save(reclamation);
                });
    }
}
