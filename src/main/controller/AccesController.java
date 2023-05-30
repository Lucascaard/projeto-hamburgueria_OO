package main.controller;

import main.model.Usuario;

public class AccesController {
    
    public static Usuario loggedUser;

    public static boolean isLoggedUser() {
        return loggedUser != null;
    }

    

    public static Boolean authentication(String log, String pass){

    String login = "login";
    String senha = "senha";
    
        if(login.equalsIgnoreCase(log) && senha.equalsIgnoreCase(pass)){
            return true;
        }
        return false;
    }
    
}
