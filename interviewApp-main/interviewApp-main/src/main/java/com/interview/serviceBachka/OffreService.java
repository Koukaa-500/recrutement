package com.interview.serviceBachka;

import com.interview.model.DTOBachka.CandidatureDto;
import com.interview.model.DTOBachka.OffreDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OffreService {
    OffreDto ajouterOffre(OffreDto offreDto);
    Boolean  SupprimerOffre(Integer id);
    OffreDto   ModifierOffre(OffreDto offreDto);
    List<OffreDto> getAllOffre();
}
