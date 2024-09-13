package com.interview.Controller1;

import com.interview.model.Entity1.Utilisateur;
import com.interview.service1.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthController {


    private final AuthService authService;

    // Endpoint for user signup
    @PostMapping("/signup")
    public ResponseEntity<Utilisateur> signUp(@RequestBody Utilisateur user) {
        try {
            Utilisateur newUser = authService.signUp(user);
            if (newUser != null) {
                return ResponseEntity.ok(newUser); // Return the new user if signup is successful
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null); // Return an error message
        }
    }

    // Endpoint for user login
    @PostMapping("/login")
    public ResponseEntity<Utilisateur> login(@RequestBody Utilisateur utilisateur) {
        try {
            Utilisateur loggedInUser = authService.login(utilisateur);
            return ResponseEntity.ok(loggedInUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

}
