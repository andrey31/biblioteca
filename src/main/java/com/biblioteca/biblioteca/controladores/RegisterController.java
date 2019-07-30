package com.biblioteca.biblioteca.controladores;

import com.biblioteca.biblioteca.modelos.entidades.Persona;
import com.biblioteca.biblioteca.modelos.PersonaDAO;
import com.biblioteca.biblioteca.vistas.JFRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adriel
 */
public class RegisterController implements ActionListener {

    JFRegister registerView = new JFRegister();
    Persona persona = new Persona();
    PersonaDAO personaDAO = new PersonaDAO();

    public RegisterController(JFRegister registerView, PersonaDAO personaDAO) throws SQLException {
        this.registerView = registerView;
        this.personaDAO = personaDAO;
        this.registerView.btnGuardar.addActionListener(this);
        this.registerView.btnModificar.addActionListener(this);
        this.registerView.btnEliminar.addActionListener(this);
        cargarPersonas();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerView.btnGuardar) {
            persona = new Persona();

            if (!verificarEspacios()) {
                try {
                    persona.setNombre(registerView.txtNombre.getText());
                    persona.setApellido1(registerView.txtApellido1.getText());
                    persona.setApellido2(registerView.txtApellido2.getText());
                    persona.setFechaNac(Date.valueOf(registerView.dpFecha.getDate()));
                    persona.setTelefono(registerView.txtTelefono.getText());
                    persona.setDireccion(registerView.txtDireccion.getText());
                    persona.setUsuario(registerView.txtUsuario.getText());
                    persona.setContrase(registerView.txtContraseña.getText());
                    persona.setTipoUsu((registerView.cmbTipo.getSelectedIndex() + 1));
                    personaDAO.Guardar(persona);
                    cargarPersonas();
                } catch (Exception ex) {
                    System.out.println("ERROR----" + ex);
                }
            }
        } else if (e.getSource() == registerView.btnModificar) {
            persona = new Persona();

            if (!verificarEspacios()) {
                try {
                    persona.setId(Integer.parseInt(registerView.txtId.getText()));
                    persona.setNombre(registerView.txtNombre.getText());
                    persona.setApellido1(registerView.txtApellido1.getText());
                    persona.setApellido2(registerView.txtApellido2.getText());
                    persona.setFechaNac(Date.valueOf(registerView.dpFecha.getDate()));
                    persona.setTelefono(registerView.txtTelefono.getText());
                    persona.setDireccion(registerView.txtDireccion.getText());
                    persona.setUsuario(registerView.txtUsuario.getText());
                    persona.setContrase(registerView.txtContraseña.getText());
                    persona.setTipoUsu((registerView.cmbTipo.getSelectedIndex() + 1));
                    personaDAO.Modificar(persona);
                    cargarPersonas();
                } catch (Exception ex) {
                    System.out.println("ERROR----" + ex);
                }
            }

        } else if (e.getSource() == registerView.btnEliminar) {
            persona = new Persona();

            if (!registerView.txtId.getText().isEmpty()) {
                try {
                    persona.setId(Integer.parseInt(registerView.txtId.getText()));
                    persona.setNombre(registerView.txtNombre.getText());
                    persona.setApellido1(registerView.txtApellido1.getText());
                    persona.setApellido2(registerView.txtApellido2.getText());
                    persona.setFechaNac(Date.valueOf(registerView.dpFecha.getDate()));
                    persona.setTelefono(registerView.txtTelefono.getText());
                    persona.setDireccion(registerView.txtDireccion.getText());
                    persona.setUsuario(registerView.txtUsuario.getText());
                    persona.setContrase(registerView.txtContraseña.getText());
                    persona.setTipoUsu((registerView.cmbTipo.getSelectedIndex() + 1));
                    personaDAO.Eliminar(persona);
                    cargarPersonas();
                } catch (Exception ex) {
                    System.out.println("ERROR----" + ex);
                }
            }
        }
    }
    
    public void cargarPersonas() throws SQLException {
        String[] columns = new String[]{"Id", "Nombre", "Apellido1", "Apellido2", "Fecha_nacimiento", "Telefono", "Direccion", "Usuario", "Contraseña", "Tipo"};
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.setColumnIdentifiers(columns);

        for (Persona persona : personaDAO.getAllPersonas()) {

            Object[] p = new Object[10];
            p[0] = persona.getId();
            p[1] = persona.getNombre();
            p[2] = persona.getApellido1();
            p[3] = persona.getApellido2();
            p[4] = persona.getFechaNac();
            p[5] = persona.getTelefono();
            p[6] = persona.getDireccion();
            p[7] = persona.getUsuario();
            p[8] = persona.getContrase();
            switch (persona.getTipoUsu()) {
                case 1:
                    p[9] = "Admin";
                    break;
                case 2:
                    p[9] = "Bibliotecario";
                    break;
                case 3:
                    p[9] = "Estudiante";
                    break;
            }
            modelTable.addRow(p);
        }
        this.registerView.tblPersona.setModel(modelTable);
    }

    public boolean verificarEspacios() {

        if (registerView.txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(registerView, "Falta campo Nombre");
            registerView.txtNombre.requestFocus(true);
            return true;
        } else if (registerView.txtApellido1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(registerView, "Falta campo Apellido Paterno");
            registerView.txtApellido1.requestFocus(true);
            return true;
        } else if (registerView.txtApellido2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(registerView, "Falta campo Apellido Materno");
            registerView.txtApellido2.requestFocus(true);
            return true;
        } else if (registerView.dpFecha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(registerView, "Falta campo Fecha");
            registerView.dpFecha.requestFocus(true);
            return true;
        } else if (registerView.txtTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(registerView, "Falta campo Telefono");
            registerView.txtTelefono.requestFocus(true);
            return true;
        } else if (registerView.txtDireccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(registerView, "Falta campo Direccion");
            registerView.txtDireccion.requestFocus(true);
            return true;
        } else if (registerView.txtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(registerView, "Falta campo Usuario");
            registerView.txtUsuario.requestFocus(true);
            return true;
        } else if (registerView.txtContraseña.getText().isEmpty()) {
            JOptionPane.showMessageDialog(registerView, "Falta campo Contraseña");
            registerView.txtContraseña.requestFocus(true);
            return true;
        }

        return false;
    }
}
