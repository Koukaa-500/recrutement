package com.interview.service1;

import com.interview.model.DTO1.OffreDto;
import com.interview.model.Entity1.Candidat;
import com.interview.model.Entity1.Enum.OffreStatus;

import java.util.List;

public interface OffreService {
    OffreDto ajouterOffre(OffreDto offreDto);
    Boolean  SupprimerOffre(Integer id);
    OffreDto   ModifierOffre(OffreDto offreDto);
    List<OffreDto> getAllOffre();

    OffreDto setOffreStatus(OffreDto offreDto, OffreStatus status);

    Long getNumberofAllOffers();
    Integer getNumberOfCandidatesPerOffer(OffreDto offreDto);
    List<OffreDto> OffresOfCandidat(Candidat candidat);

}
