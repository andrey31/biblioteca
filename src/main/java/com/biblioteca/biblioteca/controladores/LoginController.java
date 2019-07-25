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
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.JOptionPane;

/**
 *
 * @author debian-andrey
 */
public class LoginController implements ActionListener {

    JFLogin loginView = new JFLogin();
    Persona persona = new Persona();
    PersonaDAO personaDAO = new PersonaDAO();

    public LoginController(JFLogin loginView, PersonaDAO personaDAO) {
        this.loginView = loginView;
        this.personaDAO = personaDAO;
        this.loginView.btnIniciar.addActionListener(this);
        this.loginView.btnMnimizar.addActionListener(this);
        this.loginView.btnMaximizar.addActionListener(this);
        this.loginView.btnSalir.addActionListener(this);
        this.loginView.lblErrorUsu.setText("");
        this.loginView.lblErrorContra.setText("");
    }

    public void inicializarLogin() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginView.btnIniciar) {
            String usuario = String.valueOf(loginView.txtUsuario.getText());
            String contra = String.valueOf(loginView.txtContraseña.getText());
            persona = personaDAO.verificaUsuario(usuario, contra, loginView);

            if (persona != null) {
                JOptionPane.showMessageDialog(loginView, "          Datos correctos."
                        + "\n\nNombre: " + persona.getNombre() + " " + persona.getApellido1() + " " + persona.getApellido2());
                JFRegister registerView = new JFRegister();
                RegisterController RController = new RegisterController(registerView,personaDAO);
                personaDAO.listar(registerView);
                registerView.setVisible(true);
                registerView.setLocationRelativeTo(null);
                loginView.dispose();
            }
        } else if (e.getSource() == loginView.btnMnimizar) {
            loginView.setExtendedState(1);
        } else if (e.getSource() == loginView.btnMaximizar) {
            loginView.setExtendedState(MAXIMIZED_BOTH);
        } else if (e.getSource() == loginView.btnSalir) {
            loginView.dispose();
        }

    }

}
