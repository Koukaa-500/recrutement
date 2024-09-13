package com.interview.Controller1;

import com.interview.model.DTO1.InterviewDto;
import com.interview.service1.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interviews")
@RequiredArgsConstructor
public class InterviewController {

    private final InterviewService interviewService;

    // Endpoint to add an interview
    @PostMapping("/add")
    public ResponseEntity<InterviewDto> addInterview(@RequestBody InterviewDto interviewDto) {
        InterviewDto addedInterview = interviewService.ajouterInterview(interviewDto);
        return ResponseEntity.ok(addedInterview);
    }

    // Endpoint to modify an interview
    @PutMapping("/update")
    public ResponseEntity<InterviewDto> updateInterview(@RequestBody InterviewDto interviewDto) {
        InterviewDto updatedInterview = interviewService.modifierInterview(interviewDto);
        if (updatedInterview != null) {
            return ResponseEntity.ok(updatedInterview);
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if the interview does not exist
        }
    }

    // Endpoint to delete an interview
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteInterview(@RequestBody InterviewDto interviewDto) {
        boolean isDeleted = interviewService.supprimeInterview(interviewDto);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if the interview does not exist
        }
    }
}
