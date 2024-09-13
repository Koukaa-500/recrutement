package com.interview.service1;

import com.interview.model.DTO1.CandidatDto;
import com.interview.model.DTO1.CandidatureDto;
import com.interview.model.Entity1.Enum.CandidatureStatus;

import java.util.List;


public interface CandidatureService {


    CandidatureDto postuler(Integer candidatId, Integer offreId);

    //    @Override
    //    public List<CandidatureDto> getAllCandidaturebyCandidat(Integer id) {
    //        return candidatureRepository.findAll().stream()
    //                .filter(candidature -> candidature.getCandidat().getId().equals(id))
    //                .map(CandidatureMapper::convertToDTO)
    //                .toList();
    //    }
    //
    CandidatureDto changeCandidatureStatus(CandidatureDto candidatureDto, CandidatureStatus status);

    //
    Boolean supprimerCandidature(CandidatureDto candidatureDto);

    CandidatureDto getCandidatureDetails(Integer candidatureId);

    List<CandidatureDto> getall();

//    List<CandidatureDto> getAllCandidaturebyCandidat(Integer id);
//    CandidatureDto changeCandidatureStatus(CandidatureDto candidatureDto, CandidatureStatus status);
//    Boolean supprimerCandidature(CandidatureDto candidatureDto);


}
