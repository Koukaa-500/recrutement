package com.interview.service1.impl;

import com.interview.model.DTO1.OffreDto;
import com.interview.model.Entity1.Candidat;
import com.interview.model.Entity1.Enum.OffreStatus;
import com.interview.model.Entity1.Offre;
import com.interview.model.Entity1.Recruteur;
import com.interview.model.mappers.OffreMapper;
import com.interview.repository1.CandidatureRepository;
import com.interview.repository1.OffreRepository;
import com.interview.repository1.RecruteurRepository;
import com.interview.service1.OffreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OffreServiceImplementation implements OffreService {
    private final CandidatureRepository candidatureRepository;
    private final  RecruteurRepository recruteurRepositoryRepository;
    private final OffreRepository offreRepository;

    @Override
    public OffreDto ajouterOffre(OffreDto offreDto) {
        if (offreDto.getId() != null && offreRepository.existsById(offreDto.getId())) {
            return null; // Handle the case where the ID already exists
        } else {
            Offre offre = OffreMapper.convertToEntity(offreDto, recruteurRepositoryRepository.getReferenceById(offreDto.getRecruteur()));
            offre.setStatus(OffreStatus.PENDING);
            Offre savedOffre = offreRepository.save(offre);  // ID should be auto-generated
            return OffreMapper.convertToDTO(savedOffre);
        }
    }



    @Override
    public Boolean SupprimerOffre(Integer id) {
        if(!offreRepository.existsById(id))return false;

        {
            Offre offre = offreRepository.getReferenceById(id);
            Recruteur recruteur = recruteurRepositoryRepository.getReferenceById(offre.getRecruteur().getId());
            List<Offre> list = recruteur.getOffres();
            list.remove(offre);
            recruteur.setOffres(list);
            recruteurRepositoryRepository.save(recruteur);
             offreRepository.delete(offre);
            return true;
        }
    }

    @Override
    public OffreDto ModifierOffre(OffreDto offreDto) {
        Offre offre = OffreMapper.convertToEntity(offreDto,recruteurRepositoryRepository.getReferenceById(offreDto.getRecruteur()));

        return OffreMapper.convertToDTO(offreRepository.save(offre));
    }

    @Override
    public List<OffreDto> getAllOffre(){
        return offreRepository.findAll().stream().map(OffreMapper::convertToDTO).toList();
    }
    @Override
    public OffreDto setOffreStatus(OffreDto offreDto, OffreStatus status) {
        // Set the new status
        offreDto.setStatus(status);

        // Perform any additional business logic here, like saving to the database if needed
        // Example: If you want to update the entity in the database:
        Offre offre = offreRepository.findById(offreDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Offre not found"));

        offre.setStatus(status);
        offreRepository.save(offre);

        return offreDto;
    }

    @Override
    public Long getNumberofAllOffers() {
        // Use the repository to count the total number of offers
        return offreRepository.count();  // Returns the total number of rows in the Offre table
    }

    @Override
    public Integer getNumberOfCandidatesPerOffer(OffreDto offreDto) {
        Offre offre = offreRepository.findById(offreDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Offre not found"));
        return candidatureRepository.countByOffre(offre);

    }
@Override
public  List<OffreDto> OffresOfCandidat(Candidat candidat){

    return null;
}




}
