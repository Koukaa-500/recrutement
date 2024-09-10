package com.interview.ControllerBachka;

import com.interview.model.DTOBachka.CandidatureDto;
import com.interview.model.DTOBachka.OffreDto;
import com.interview.serviceBachka.CandidatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("candidature")
public class CandidatureController {
    private final CandidatureService candidatureService;
    @PostMapping("/postuler")
    public ResponseEntity<CandidatureDto> postuler(@RequestBody CandidatureDto candidature)

    {
        return ResponseEntity.ok(candidatureService.postuler(candidature));
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<CandidatureDto>> modifierOffre(@PathVariable Integer id)
    {
        return ResponseEntity.ok(candidatureService.getAllCandidaturebyCandidat(id));
    }
}
