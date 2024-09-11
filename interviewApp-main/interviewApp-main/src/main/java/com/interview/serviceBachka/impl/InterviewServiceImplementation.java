package com.interview.serviceBachka.impl;

import com.interview.model.DTOBachka.CandidatDto;
import com.interview.model.DTOBachka.InterviewDto;
import com.interview.model.EntityBachka.Candidat;
import com.interview.model.EntityBachka.Interview;
import com.interview.repositoryBachka.CandidatRepository;
import com.interview.repositoryBachka.InterviewRepository;
import com.interview.serviceBachka.InterviewService;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import static com.interview.model.mappers.CandidatMapper.convertToDTO;
import static com.interview.model.mappers.CandidatMapper.convertToEntity;

import static com.interview.model.mappers.InterviewMapper.convertToDTO;
import static com.interview.model.mappers.InterviewMapper.convertToEntity;

@Service
@RequiredArgsConstructor

public class InterviewServiceImplementation implements InterviewService {
    private  final  InterviewRepository interviewRepository;
    private final CandidatRepository candidatRepository;


    @Override
    public InterviewDto ajouterInterview(InterviewDto interviewDto) {
        // Convert DTO to Entity
        Interview interview = convertToEntity(interviewDto);

        // Save entity to the database
        interview = interviewRepository.save(interview);

        // Convert Entity back to DTO and return
        return convertToDTO(interview);
    }

    @Override
    public InterviewDto modifierInterview(InterviewDto interviewDto) {
        Optional<Interview> existingInterview = interviewRepository.findById(interviewDto.getId());
         if (existingInterview.isPresent()) {
             existingInterview.get().setDateHeure(interviewDto.getDateHeure());
             existingInterview.get().setResponsable(interviewDto.getResponsable());

             // Save the modified interview
              interviewRepository.save((existingInterview.get()));
             return convertToDTO(existingInterview.get());
         }

        return null; // Handle case when interview does not exist
    }

    @Override
    public Boolean supprimeInterview(InterviewDto interviewDto) {
        Optional<Interview> existingInterview = interviewRepository.findById(interviewDto.getId());

        if (existingInterview.isPresent()) {
            interviewRepository.delete(existingInterview.get());
            return true;
        }

        return false; // Return false if the interview was not found
    }

    @Override
    public InterviewDto ajouterInterviewACandidat(InterviewDto interviewDto, CandidatDto candidatDto) {
        // Convert DTOs to Entities
        Interview interview = convertToEntity(interviewDto);
        Candidat candidat = convertToEntity(candidatDto);

        // Check if the Candidat exists or needs to be created
        Optional<Candidat> existingCandidat = candidatRepository.findByEmail(candidat.getEmail());
        if (existingCandidat.isPresent()) {
            candidat = existingCandidat.get();
        } else {
            return null;
        }

        // Associate the Interview with the Candidat
        List<Interview> list =candidat.getInterviews();
        list.add(interview);
        candidat.setInterviews(list);
        candidatRepository.save(candidat);
        return convertToDTO(interview);
    }
    }
