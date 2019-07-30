package com.biblioteca.biblioteca;

import com.biblioteca.biblioteca.controladores.DevolucionController;
import com.biblioteca.biblioteca.modelos.entidades.Persona;
import com.biblioteca.biblioteca.modelos.PersonaDAO;
import com.biblioteca.biblioteca.vistas.JFLogin;
import com.biblioteca.biblioteca.controladores.LoginController;
import java.sql.SQLException;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        JFLogin loginView = new JFLogin();
        PersonaDAO personaDAO = new PersonaDAO();
        LoginController lController = new LoginController(loginView, personaDAO);
        loginView.setVisible(true);
        loginView.setLocationRelativeTo(null);
//DevolucionController dev = new DevolucionController();
    }

}
