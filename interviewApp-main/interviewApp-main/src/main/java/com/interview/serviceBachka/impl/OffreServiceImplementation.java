package com.interview.serviceBachka.impl;

import com.interview.model.DTOBachka.CandidatureDto;
import com.interview.model.DTOBachka.OffreDto;
import com.interview.model.EntityBachka.Candidature;
import com.interview.model.EntityBachka.Offre;
import com.interview.model.EntityBachka.Recruteur;
import com.interview.model.EntityBachka.Utilisateur;
import com.interview.model.mappers.OffreMapper;
import com.interview.repositoryBachka.OffreRepository;
import com.interview.repositoryBachka.RecruteurRepository;
import com.interview.serviceBachka.OffreService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OffreServiceImplementation implements OffreService {
    private final  RecruteurRepository recruteurRepositoryRepository;
    private final OffreRepository offreRepository;

    @Override
    public OffreDto ajouterOffre(OffreDto offreDto) {
        if(offreRepository.existsById(offreDto.getId()))return null;
        else {
            Offre offre = OffreMapper.convertToEntity(offreDto);
            Recruteur recruteur = offre.getRecruteur();
            List<Offre> list = recruteur.getOffres();
            list.add(offre);
            recruteur.setOffres(list);
            recruteurRepositoryRepository.save(recruteur);
            return OffreMapper.convertToDTO(offreRepository.save(offre));
        }
        }


    @Override
    public Boolean SupprimerOffre(Integer id) {
        if(!offreRepository.existsById(id))return false;

        {
            Offre offre = offreRepository.getReferenceById(id);
            Recruteur recruteur = offre.getRecruteur();
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
        Offre offre = OffreMapper.convertToEntity(offreDto);

        return OffreMapper.convertToDTO(offreRepository.save(offre));
    }
    @Override
    public List<OffreDto> getAllOffre(){
        return offreRepository.findAll().stream().map(OffreMapper::convertToDTO).toList();
    }


}
