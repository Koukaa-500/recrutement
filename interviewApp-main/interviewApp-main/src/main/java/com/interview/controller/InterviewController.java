package com.interview.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.model.dto.InterviewDto;
import com.interview.services.InterviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("interview")
@RequiredArgsConstructor
public class InterviewController {
	private final InterviewService interviewService;
	@PostMapping("/{id}")
	public ResponseEntity<InterviewDto> addOneUser(@RequestBody InterviewDto interview, @PathVariable long idCandidat)
	
	{
		return ResponseEntity.ok(interviewService.addOneInterview(interview,idCandidat));
	}
	@GetMapping
	public ResponseEntity<Page<InterviewDto>> getUsers(Pageable pageable)
	{
		return ResponseEntity.ok(interviewService.getInterviews(pageable));
	}
	@GetMapping("/{id}")
	public ResponseEntity<InterviewDto> getOneInterview(@PathVariable long id)
	{
		return ResponseEntity.ok(interviewService.getOneInterview(id));
	}
	@DeleteMapping("/{id}")
	public void deleteOne(@PathVariable long id )
	{
		interviewService.deleteOneInterview(id);
	}

}
