package com.interview.service1;

import com.interview.model.DTO1.CandidatDto;
import com.interview.model.DTO1.InterviewDto;

public interface InterviewService {
    InterviewDto ajouterInterview(InterviewDto interviewDto);
    InterviewDto modifierInterview(InterviewDto interviewDto);
    Boolean supprimeInterview(InterviewDto interviewDto);
    InterviewDto ajouterInterviewACandidat(InterviewDto interviewDto, CandidatDto candidatDto);


}
