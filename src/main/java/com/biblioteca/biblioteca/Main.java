package com.biblioteca.biblioteca;

import com.biblioteca.biblioteca.modelos.Persona;
import com.biblioteca.biblioteca.modelos.PersonaDAO;
import com.biblioteca.biblioteca.vistas.JFLogin;
import com.biblioteca.biblioteca.controladores.LoginController;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFLogin loginView = new JFLogin();
        PersonaDAO personaDAO = new PersonaDAO();
        LoginController lController = new LoginController(loginView, personaDAO);
        loginView.setVisible(true);
        loginView.setLocationRelativeTo(null);
    }

}
