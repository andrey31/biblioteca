/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.controladores;

import com.biblioteca.biblioteca.modelos.entidades.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.biblioteca.biblioteca.vistas.*;
import com.biblioteca.biblioteca.modelos.*;
import java.sql.SQLException;

/**
 *
 * @author debian-andrey
 */
public class LoginController implements ActionListener {

    JFLogin loginView = new JFLogin();
    Persona persona = new Persona();
    PersonaDAO personaDAO = new PersonaDAO();

    public LoginController() {
        this.loginView.setVisible(true);
        this.loginView.setLocationRelativeTo(null);
        this.loginView.btnIniciar.addActionListener(this);
        this.loginView.btnMnimizar.addActionListener(this);
        this.loginView.btnMaximizar.addActionListener(this);
        this.loginView.btnSalir.addActionListener(this);
        this.loginView.lblErrorUsu.setText("");
        this.loginView.lblErrorContra.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginView.btnIniciar) {
            String usuario = String.valueOf(loginView.txtUsuario.getText());
            String contra = String.valueOf(loginView.txtContraseña.getText());
            persona = personaDAO.verificaUsuario(usuario, contra, loginView);
            if (persona != null) {
                JFMenuPrincipal menuView = new JFMenuPrincipal();
                JFRegister registerView = new JFRegister();
                menuView.setVisible(true);
                menuView.setLocationRelativeTo(null);
                /*registerView.setVisible(true);
                registerView.setLocationRelativeTo(null);*/
                loginView.dispose();
            }
        }

    }

}
