package com.interview.serviceBachka.impl;

import com.interview.model.DTO1.CandidatureDto;
import com.interview.model.Entity1.Candidat;
import com.interview.model.Entity1.Candidature;
import com.interview.model.Entity1.Enum.CandidatureStatus;
import com.interview.model.mappers.CandidatureMapper;
import com.interview.repository1.CandidatRepository;
import com.interview.repository1.CandidatureRepository;
import com.interview.serviceBachka.CandidatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidatureServiceImplementation implements CandidatureService {
    private final CandidatureRepository candidatureRepository;
    private final CandidatRepository candidatRepository;

    @Override
    public CandidatureDto postuler(CandidatureDto candidatureDto) {
        Candidature candidature= CandidatureMapper.convertToEntity(candidatureDto);
        Candidat candidat= candidature.getCandidat();
        candidat.getOffres().add(candidature.getOffre());
        candidatRepository.save(candidat);
        return CandidatureMapper.convertToDTO( candidatureRepository.save(candidature));

    }

    @Override
    public List<CandidatureDto> getAllCandidaturebyCandidat(Integer id) {
        return candidatureRepository.findAll().stream().filter(candidature -> candidature.getCandidat().getId().equals(id)).
                map(CandidatureMapper::convertToDTO).toList();
    }

    @Override
    public CandidatureDto changeCandidatureStatus(CandidatureDto candidatureDto, CandidatureStatus status) {
        Candidature candidature= CandidatureMapper.convertToEntity(candidatureDto);
        candidature.setStatus(status);
        return CandidatureMapper.convertToDTO( candidatureRepository.save(candidature));

    }

    @Override
    public Boolean supprimerCandidature(CandidatureDto candidatureDto) {

         candidatureRepository.delete(CandidatureMapper.convertToEntity( candidatureDto));
         return true;
    }

}
