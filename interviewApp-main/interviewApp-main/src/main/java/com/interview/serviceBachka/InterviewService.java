package com.interview.serviceBachka;

import com.interview.model.DTOBachka.CandidatDto;
import com.interview.model.DTOBachka.InterviewDto;

public interface InterviewService {
    InterviewDto ajouterInterview(InterviewDto interviewDto);
    InterviewDto modifierInterview(InterviewDto interviewDto);
    Boolean supprimeInterview(InterviewDto interviewDto);
    InterviewDto ajouterInterviewACandidat(InterviewDto interviewDto, CandidatDto candidatDto);


}
