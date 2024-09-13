package com.interview.service1;

import com.interview.model.Entity1.Utilisateur;

public interface AuthService {
    public Utilisateur signUp(Utilisateur user);

    public Utilisateur login(Utilisateur user) ;
}