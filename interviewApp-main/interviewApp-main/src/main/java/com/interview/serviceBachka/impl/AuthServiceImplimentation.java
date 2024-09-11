package com.interview.serviceBachka.impl;

import com.interview.model.EntityBachka.Administrateur;
import com.interview.model.EntityBachka.Candidat;
import com.interview.model.EntityBachka.Enum.RoleUtilisateur;
import com.interview.model.EntityBachka.Recruteur;
import com.interview.model.EntityBachka.Utilisateur;
import com.interview.repositoryBachka.AdministrateurRepository;
import com.interview.repositoryBachka.CandidatRepository;
import com.interview.repositoryBachka.RecruteurRepository;
import com.interview.serviceBachka.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.interview.model.EntityBachka.Enum.RoleUtilisateur.*;

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
    public Utilisateur login(String email, String rawPassword) {
        if (administrateurRepository.existsByEmail(email)) {
            Administrateur user = administrateurRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Administrateur not found"));
            if (passwordEncoder.matches(rawPassword, user.getMotDePasse())) {
                return user;
            } else {
                throw new RuntimeException("Invalid password for Administrateur");
            }
        }

        // Check if the user is a Recruteur
        if (recruteurRepository.existsByEmail(email)) {
            Recruteur user = recruteurRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Recruteur not found"));
            if (passwordEncoder.matches(rawPassword, user.getMotDePasse())) {
                return user;
            } else {
                throw new RuntimeException("Invalid password for Recruteur");
            }
        }

        // Check if the user is a Candidat
        if (candidatRepository.existsByEmail(email)) {
            Candidat user = candidatRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Candidat not found"));
            if (passwordEncoder.matches(rawPassword, user.getMotDePasse())) {
                return user;
            } else {
                throw new RuntimeException("Invalid password for Candidat");
            }
        }

        // If no user found, throw an exception
        throw new RuntimeException("User not found");
    }


}
