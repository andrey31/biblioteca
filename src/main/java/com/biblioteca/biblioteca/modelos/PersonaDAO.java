package com.biblioteca.biblioteca.modelos;

import com.biblioteca.biblioteca.vistas.JFLogin;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Adriel
 */
public class PersonaDAO {

    Conexion con;
    JFLogin loginView = new JFLogin();

    public PersonaDAO() {
        con = new Conexion();
    }

    public Persona verificaUsuario(String usuario, String contraseña, JFLogin loginView) {
        Persona persona = null;
        this.loginView = loginView;
        this.loginView.lblErrorUsu.setText("");
        this.loginView.lblErrorContra.setText("");
        String error = "", errorUsu = "", errorContra = "";

        if (!usuario.isEmpty()) {

            if (!contraseña.isEmpty()) {
                con.connect();
                Connection accesoDB = con.getConnection();

                try {
                    PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM Usuarios WHERE usuario=?");
                    ps.setString(1, usuario);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        persona = new Persona();
                        persona.setUsuario(rs.getString(2));

                        if (usuario.equals(persona.getUsuario())) {
                            ps = accesoDB.prepareStatement("SELECT * FROM Usuarios WHERE contrasena=?");
                            ps.setString(1, contraseña);
                            rs = ps.executeQuery();

                            if (rs.next()) {
                                persona.setContrase(rs.getString(3));

                                if (contraseña.equals(persona.getContrase())) {
                                    persona.setId(Integer.parseInt(rs.getString(4)));
                                    persona.setTipoUsu(Integer.parseInt(rs.getString(5)));

                                    ps = accesoDB.prepareStatement("SELECT * FROM Personas WHERE id=?");

                                    ps.setString(1, String.valueOf(persona.getId()));
                                    rs = ps.executeQuery();

                                    if (rs.next()) {
                                        persona.setNombre(rs.getString(2));
                                        persona.setApellido1(rs.getString(3));
                                        persona.setApellido2(rs.getString(4));
                                        persona.setFechaNac(rs.getString(5));
                                        persona.setTelefono(rs.getString(6));
                                        persona.setDireccion(rs.getString(7));
                                        return persona;
                                    }
                                }
                            } else {
                                errorContra = "Contraseña incorrecta";
                            }
                        }
                    } else {
                        errorUsu = "Usuario incorrecto";
                    }
                } catch (Exception e) {
                }
            } else {
                error = "Debe rellenar el campo de contraseña";
                this.loginView.lblErrorContra.setText(error);
            }
        } else {
            error = "Debe rellenar el campo de usuario";
            this.loginView.lblErrorUsu.setText(error);
            if (contraseña.isEmpty()) {
                error = "Debe rellenar el campo de contraseña";
                this.loginView.lblErrorContra.setText(error);
            }
        }

        if (!errorUsu.isEmpty()) {
            this.loginView.lblErrorUsu.setText(errorUsu);
            Persona p = null;
            return p;
        } else if (!errorContra.isEmpty()) {
            this.loginView.lblErrorContra.setText(errorContra);
            Persona p = null;
            return p;
        }
        return persona;
    }
}
