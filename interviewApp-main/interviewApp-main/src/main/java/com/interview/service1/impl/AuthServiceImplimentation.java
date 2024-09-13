package com.interview.service1.impl;

import com.interview.model.Entity1.Administrateur;
import com.interview.model.Entity1.Candidat;
import com.interview.model.Entity1.Recruteur;
import com.interview.model.Entity1.Utilisateur;
import com.interview.repository1.AdministrateurRepository;
import com.interview.repository1.CandidatRepository;
import com.interview.repository1.RecruteurRepository;
import com.interview.service1.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.interview.model.Entity1.Enum.RoleUtilisateur.*;

@Service
@RequiredArgsConstructor
public class AuthServiceImplimentation implements AuthService {
    private final RecruteurRepository recruteurRepository;
    private final CandidatRepository candidatRepository;
    private final AdministrateurRepository administrateurRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Utilisateur signUp(Utilisateur user) {
        String encodedPassword = passwordEncoder.encode(user.getMotDePasse());

        if (user.getRole() .equals(admin) ) {
            if (recruteurRepository.existsByEmail(user.getEmail()) || candidatRepository.existsByEmail(user.getEmail())) {
                throw new RuntimeException("User with this email is already a Recruteur or Candidat.");
            }

            Administrateur newUser = new Administrateur();
            newUser.setNom(user.getNom());
            newUser.setAge(user.getAge());
            newUser.setPrenom(user.getPrenom());
            newUser.setMotDePasse(encodedPassword);
            newUser.setEmail(user.getEmail());

            if (!administrateurRepository.existsByEmail(newUser.getEmail())) {
                return administrateurRepository.save(newUser);
            } else {
                return null;
            }
        }

        if (user.getRole() .equals(recruteur) ) {
            if (administrateurRepository.existsByEmail(user.getEmail()) || candidatRepository.existsByEmail(user.getEmail())) {
                throw new RuntimeException("User with this email is already an Administrateur or Candidat.");
            }

            Recruteur newUser = new Recruteur();
            newUser.setNom(user.getNom());
            newUser.setAge(user.getAge());
            newUser.setPrenom(user.getPrenom());
            newUser.setMotDePasse(encodedPassword);
            newUser.setEmail(user.getEmail());

            if (!recruteurRepository.existsByEmail(newUser.getEmail())) {
                return recruteurRepository.save(newUser);
            } else {
                return null;
            }
        }

        if (user.getRole() .equals(candidat) ) {
            if (administrateurRepository.existsByEmail(user.getEmail()) || recruteurRepository.existsByEmail(user.getEmail())) {
                throw new RuntimeException("User with this email is already an Administrateur or Recruteur.");
            }

            Candidat newUser = new Candidat();
            newUser.setNom(user.getNom());
            newUser.setAge(user.getAge());
            newUser.setPrenom(user.getPrenom());
            newUser.setMotDePasse(encodedPassword);
            newUser.setEmail(user.getEmail());

            if (!candidatRepository.existsByEmail(newUser.getEmail())) {
                return candidatRepository.save(newUser);
            } else {
                return null;
            }
        }

        return null;
    }
    @Override
    public Utilisateur login(Utilisateur user) {
        if (administrateurRepository.existsByEmail(user.getEmail())) {
            Administrateur newuser = administrateurRepository.findByEmail(user.getEmail())
                    .orElseThrow(() -> new RuntimeException("Administrateur not found"));
            if (passwordEncoder.matches(user.getMotDePasse(), newuser.getMotDePasse())) {
                return newuser;  // Return the full user object from the database
            } else {
                throw new RuntimeException("Invalid password for Administrateur");
            }
        }

        // Check for Recruteur
        if (recruteurRepository.existsByEmail(user.getEmail())) {
            Recruteur newuser = recruteurRepository.findByEmail(user.getEmail())
                    .orElseThrow(() -> new RuntimeException("Recruteur not found"));
            if (passwordEncoder.matches(user.getMotDePasse(), newuser.getMotDePasse())) {
                return newuser;  // Return full user object
            } else {
                throw new RuntimeException("Invalid password for Recruteur");
            }
        }

        // Check for Candidat
        if (candidatRepository.existsByEmail(user.getEmail())) {
            Candidat newuser = candidatRepository.findByEmail(user.getEmail())
                    .orElseThrow(() -> new RuntimeException("Candidat not found"));
            if (passwordEncoder.matches(user.getMotDePasse(), newuser.getMotDePasse())) {
                return newuser;  // Return full user object
            } else {
                throw new RuntimeException("Invalid password for Candidat");
            }
        }

        // If no user found, throw an exception
        throw new RuntimeException("User not found");
    }



}
