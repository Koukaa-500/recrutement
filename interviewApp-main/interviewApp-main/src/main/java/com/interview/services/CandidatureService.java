package com.interview.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.interview.model.dto.CandidatureDto;

public interface CandidatureService {
	public CandidatureDto addOneCandidature(CandidatureDto candidature,long idCandidat);
	public Page<CandidatureDto> getCandidatures(Pageable pageable);
	public CandidatureDto getOneCandidature(long id);
	public void deleteOneCandidature(long id);
}
