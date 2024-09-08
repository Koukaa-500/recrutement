package com.interview.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.interview.model.dto.InterviewDto;

public interface InterviewService {
	public InterviewDto addOneInterview(InterviewDto interview,long idCandidat);
	public Page<InterviewDto> getInterviews(Pageable pageable);
	public InterviewDto getOneInterview(long id);
	public void deleteOneInterview(long id);
}
