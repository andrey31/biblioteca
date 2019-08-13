package com.biblioteca.biblioteca;

import com.biblioteca.biblioteca.modelos.PersonaDAO;
import com.biblioteca.biblioteca.vistas.JFLogin;
import com.biblioteca.biblioteca.controladores.LoginController;
import java.sql.SQLException;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        LoginController lController = new LoginController();
    }
}
