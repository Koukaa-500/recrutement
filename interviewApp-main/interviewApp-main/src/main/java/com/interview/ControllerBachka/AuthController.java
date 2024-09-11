package com.interview.ControllerBachka;

import com.interview.model.EntityBachka.Utilisateur;
import com.interview.serviceBachka.AuthService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Utilisateur> login(@RequestParam String email, @RequestParam String password) {
        try {
            Utilisateur loggedInUser = authService.login(email, password);
            return ResponseEntity.ok(loggedInUser); // Return the user if login is successful
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null); // Return an error message
        }
    }
}
