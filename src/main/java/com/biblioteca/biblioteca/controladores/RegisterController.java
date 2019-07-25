package com.biblioteca.biblioteca.controladores;

import com.biblioteca.biblioteca.modelos.entidades.Persona;
import com.biblioteca.biblioteca.modelos.PersonaDAO;
import com.biblioteca.biblioteca.vistas.JFRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Adriel
 */
public class RegisterController implements ActionListener{
    JFRegister registerView = new JFRegister();
    Persona persona = new Persona();
    PersonaDAO personaDAO = new PersonaDAO();

    public RegisterController(JFRegister registerView, PersonaDAO personaDAO) {
        this.registerView = registerView;
        this.personaDAO=personaDAO;
        this.personaDAO.listar(this.registerView);
        this.registerView.btnGuardar.addActionListener(this);
        this.registerView.btnModificar.addActionListener(this);
        this.registerView.btnEliminar.addActionListener(this);
        this.registerView.btnMinimizar.addActionListener(this);
        this.registerView.btnMaximizar.addActionListener(this);
        this.registerView.btnSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerView.btnGuardar){
            persona= new Persona();
            persona.setNombre(registerView.txtNombre.getText());
            persona.setApellido1(registerView.txtApellido1.getText());
            persona.setApellido2(registerView.txtApellido2.getText());
            persona.setFechaNac(registerView.txtAno.getText()+"-"+registerView.txtMes.getText()+"-"+registerView.txtDia.getText());
            persona.setTelefono(registerView.txtTelefono.getText());
            persona.setDireccion(registerView.txtDireccion.getText());
            persona.setUsuario(registerView.txtUsuario.getText());
            persona.setContrase(registerView.txtContraseña.getText());
            persona.setTipoUsu(1);
            personaDAO.Guardar(persona);
        }
    }
    
}
