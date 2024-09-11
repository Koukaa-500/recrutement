package com.interview.serviceBachka;

import com.interview.model.EntityBachka.Utilisateur;

public interface AuthService {
    public Utilisateur signUp(Utilisateur user);

    public Utilisateur login(String email, String rawPassword);
}