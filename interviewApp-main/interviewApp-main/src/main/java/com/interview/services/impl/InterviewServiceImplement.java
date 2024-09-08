package com.interview.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.interview.model.dto.InterviewDto;
import com.interview.model.dto.InterviewDto;
import com.interview.model.entity.Interview;
import com.interview.model.entity.Utilisateur;
import com.interview.model.mappers.InterviewMapper;
import com.interview.repositories.InterviewRepository;
import com.interview.repositories.UtilisateurRepository;
import com.interview.services.InterviewService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class InterviewServiceImplement implements InterviewService {
	private final InterviewRepository interviewRepository;
	private final UtilisateurRepository utilisateurRepository;

	@Override
	public InterviewDto addOneInterview(InterviewDto interview, long idCandidat) {
		// TODO Auto-generated method stub
		Interview inv=InterviewMapper.convertToEntity(interview);
		Utilisateur candidat=utilisateurRepository.findById(idCandidat).orElse(null);
		if(candidat!=null)
		{
			inv.setParticipant(candidat);
			return InterviewMapper.convertToDTO(interviewRepository.save(inv));
			
		}
		else
		return null;
	}

	@Override
	public Page<InterviewDto> getInterviews(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<Interview> interviews=interviewRepository.findAll(pageable);
		
		return interviews.map(InterviewMapper::convertToDTO);
	}

	@Override
	public InterviewDto getOneInterview(long id) {
		// TODO Auto-generated method stub
		return InterviewMapper.convertToDTO(interviewRepository.findById(id).orElse(null));
	}

	@Override
	public void deleteOneInterview(long id) {
		// TODO Auto-generated method stub
		interviewRepository.deleteById(id);

	}

}
