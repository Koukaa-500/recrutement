package com.interview.serviceBachka;

import com.interview.model.DTOBachka.CandidatureDto;
import com.interview.model.EntityBachka.Candidature;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CandidatureService {
    CandidatureDto postuler(CandidatureDto candidatureDto);
    List<CandidatureDto> getAllCandidaturebyCandidat(Integer id);
}
