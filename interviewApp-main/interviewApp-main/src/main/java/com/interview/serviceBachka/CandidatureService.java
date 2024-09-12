package com.interview.serviceBachka;

import com.interview.model.DTO1.CandidatureDto;
import com.interview.model.Entity1.Enum.CandidatureStatus;

import java.util.List;


public interface CandidatureService {
    CandidatureDto postuler(CandidatureDto candidatureDto);
    List<CandidatureDto> getAllCandidaturebyCandidat(Integer id);
    CandidatureDto changeCandidatureStatus(CandidatureDto candidatureDto, CandidatureStatus status);
    Boolean supprimerCandidature(CandidatureDto candidatureDto);


}
