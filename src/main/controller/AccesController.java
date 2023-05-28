package main.controller;

import main.model.Usuario;

public class AccesController {
    
    public static Usuario loggedUser;

    public static boolean isLoggedUser() {
        return loggedUser != null;
    }

    // fazer método de autenticar depois de resolver banco de dados
}
