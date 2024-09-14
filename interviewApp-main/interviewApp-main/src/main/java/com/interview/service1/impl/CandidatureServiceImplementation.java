package com.interview.service1.impl;

import com.interview.model.DTO1.CandidatureDto;
import com.interview.model.Entity1.Candidat;
import com.interview.model.Entity1.Candidature;
import com.interview.model.Entity1.Enum.CandidatureStatus;
import com.interview.model.Entity1.Offre;
import com.interview.model.mappers.CandidatMapper;
import com.interview.model.mappers.CandidatureMapper;
import com.interview.repository1.CandidatRepository;
import com.interview.repository1.CandidatureRepository;
import com.interview.repository1.OffreRepository;
import com.interview.service1.CandidatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidatureServiceImplementation implements CandidatureService {
    private final CandidatureRepository candidatureRepository;
    private final CandidatRepository candidatRepository;
    private final OffreRepository offreRepository; // Add this to manage Offre entities


    @Override
    public CandidatureDto postuler(Integer candidatId, Integer offreId) {
        // Fetch Offre and Candidat entities from their IDs
        Offre offre = offreRepository.findById(offreId)
                .orElseThrow(() -> new IllegalArgumentException("Offre not found"));
        Candidat candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new IllegalArgumentException("Candidat not found"));

        // Create a new Candidature entity
        Candidature candidature = new Candidature();
        candidature.setStatus(CandidatureStatus.PENDING); // Set default status
        candidature.setOffre(offreId); // Save only the offer ID
        candidature.setCandidat(candidatId); // Save only the candidate ID

        // Save the Candidature entity
        candidatureRepository.save(candidature);

        // Convert the saved Candidature to DTO and return
        return CandidatureMapper.convertToDTO(candidature);
    }


//    @Override
//    public List<CandidatureDto> getAllCandidaturebyCandidat(Integer id) {
//        return candidatureRepository.findAll().stream()
//                .filter(candidature -> candidature.getCandidat().getId().equals(id))
//                .map(CandidatureMapper::convertToDTO)
//                .toList();
//    }

    @Override
    public CandidatureDto changeCandidatureStatus(CandidatureDto candidatureDto, CandidatureStatus status) {
        Candidature candidature = candidatureRepository.findById(candidatureDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Candidature not found"));
        candidature.setStatus(status);
        return CandidatureMapper.convertToDTO(candidatureRepository.save(candidature));
    }

    //
    @Override
    public Boolean supprimerCandidature(CandidatureDto candidatureDto) {
        Candidature candidature = candidatureRepository.findById(candidatureDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Candidature not found"));
        candidatureRepository.delete(candidature);
        return true;
    }


    @Override
    public CandidatureDto getCandidatureDetails(Integer candidatureId) {
        // Fetch the Candidature entity from the repository
        Candidature candidature = candidatureRepository.findById(candidatureId)
                .orElseThrow(() -> new IllegalArgumentException("Candidature not found"));

        // Fetch the Offre and Candidat entities using their IDs
        Offre offre = offreRepository.findById(candidature.getOffre())
                .orElseThrow(() -> new IllegalArgumentException("Offre not found"));
        Candidat candidat = candidatRepository.findById(candidature.getCandidat())
                .orElseThrow(() -> new IllegalArgumentException("Candidat not found"));


        return CandidatureMapper.convertToDTO(candidature);
    }


    @Override
    public List<CandidatureDto> getall() {
        return candidatureRepository.findAll().stream().map(CandidatureMapper::convertToDTO).toList();
    }

}
