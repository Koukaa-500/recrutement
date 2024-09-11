package com.interview.serviceBachka.impl;

import com.interview.model.DTOBachka.CandidatureDto;
import com.interview.model.EntityBachka.Candidature;
import com.interview.model.EntityBachka.Enum.CandidatureStatus;
import com.interview.model.mappers.CandidatureMapper;
import com.interview.repositoryBachka.CandidatureRepository;
import com.interview.serviceBachka.CandidatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidatureServiceImplementation implements CandidatureService {
    private final CandidatureRepository candidatureRepository;
    @Override
    public CandidatureDto postuler(CandidatureDto candidatureDto) {
        Candidature candidature= CandidatureMapper.convertToEntity(candidatureDto);
        return CandidatureMapper.convertToDTO( candidatureRepository.save(candidature));

    }

    @Override
    public List<CandidatureDto> getAllCandidaturebyCandidat(Integer id) {
        return candidatureRepository.findAll().stream().filter(candidature -> candidature.getId().equals(id)).
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
        return null;
    }

}
