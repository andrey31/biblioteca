package com.biblioteca.biblioteca.modelos;

import com.biblioteca.biblioteca.modelos.entidades.Persona;
import com.biblioteca.biblioteca.vistas.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adriel
 */
public class PersonaDAO {

    Conexion con;
    JFLogin loginView = new JFLogin();
    JFRegister registerView = new JFRegister();

    public PersonaDAO() {
        con = new Conexion();
    }

    public void Guardar(Persona persona) {
        Persona p = persona;
        con.connect();
        Connection accesoDB = con.getConnection();

        try {
            PreparedStatement ps = accesoDB.prepareStatement("INSERT INTO Personas VALUES (NULL, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido1());
            ps.setString(3, p.getApellido2());
            ps.setString(4, p.getFechaNac());
            ps.setString(5, p.getTelefono());
            ps.setString(6, p.getDireccion());
            ps.executeUpdate();

            ps = accesoDB.prepareStatement("SELECT LAST_INSERT_ID()");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                p.setId(rs.getShort(1));
                ps = accesoDB.prepareStatement("INSERT INTO Usuarios VALUES (NULL, ?, ?, ?, ?)");
                ps.setString(1, p.getUsuario());
                ps.setString(2, p.getContrase());
                ps.setString(3, String.valueOf(p.getId()));
                ps.setString(4, String.valueOf(p.getTipoUsu()));
                ps.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println("ERROR---- " + e);
        }
        con.closeConnection();
        JOptionPane.showMessageDialog(registerView, "Registrado");
    }

    public void listar(JFRegister registerView) {
        this.registerView = registerView;
        con.connect();
        Connection accesoDB = con.getConnection();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Apellido 1");
        model.addColumn("Apellido 2");
        model.addColumn("Fecha_Nac");
        model.addColumn("Telefono");
        model.addColumn("Direccion");
        model.addColumn("Usuario");
        model.addColumn("Contraseña");
        model.addColumn("Tipo");

        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM Usuarios");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsMD = rs.getMetaData();
            while (rs.next()) {
                Object[] filas = new Object[rsMD.getColumnCount()];
                for (int x = 1; x <= rsMD.getColumnCount(); x++) {
                    filas[x] = rs.getObject(x);
                }
                model.addRow(filas);
            }
        } catch (Exception e) {
        }
        con.closeConnection();
        this.registerView.tblPersona.setModel(model);
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
                                        con.closeConnection();
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
            con.closeConnection();
            return p;
        } else if (!errorContra.isEmpty()) {
            this.loginView.lblErrorContra.setText(errorContra);
            Persona p = null;
            con.closeConnection();
            return p;
        }
        con.closeConnection();
        return persona;
    }
}
