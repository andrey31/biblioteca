package com.biblioteca.biblioteca.modelos;

import com.biblioteca.biblioteca.modelos.entidades.Persona;
import com.biblioteca.biblioteca.vistas.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
            ps.setDate(4, p.getFechaNac());
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
            System.out.println("ERROR----" + e);
        }
        con.closeConnection();
        JOptionPane.showMessageDialog(registerView, "Registrado");
    }

   public List<Persona> getAllPersonas() throws SQLException{
        con.connect();
        Connection connection = con.getConnection();
        
        String query = "SELECT Personas.*, Usuarios.usuario,Usuarios.contrasena, Tipo_Usuario.id_tipo FROM Personas, Usuarios,"
                + " Tipo_Usuario WHERE Usuarios.fk_persona = Personas.id AND Usuarios.fk_tipo = Tipo_Usuario.id_tipo";
        
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        
        List<Persona> personas = new ArrayList<>();
        
        while(rs.next()){
            Persona persona = new Persona(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido1"),
                    rs.getString("apellido2"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("usuario"),
                    rs.getString("contrasena"),
                    rs.getInt("id_tipo")
            );
            
            personas.add(persona); 
        }
        con.closeConnection();
        return personas;
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
                        ps = accesoDB.prepareStatement("SELECT * FROM Usuarios WHERE contrasena=?");
                        ps.setString(1, contraseña);
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            ps = accesoDB.prepareStatement("SELECT Personas.*, Usuarios.usuario,Usuarios.contrasena,Usuarios.fk_tipo FROM Personas, Usuarios WHERE Usuarios.usuario = ? AND Usuarios.contrasena = ? AND Personas.id = Usuarios.fk_persona");
                            ps.setString(1, usuario);
                            ps.setString(2, contraseña);
                            rs = ps.executeQuery();
                            if (rs.next()) {
                                persona.setId(Integer.parseInt(rs.getString(1)));
                                persona.setNombre(rs.getString(2));
                                persona.setApellido1(rs.getString(3));
                                persona.setApellido2(rs.getString(4));
                                persona.setFechaNac(rs.getDate(5));
                                persona.setTelefono(rs.getString(6));
                                persona.setDireccion(rs.getString(7));
                                persona.setUsuario(rs.getString(8));
                                persona.setContrase(rs.getString(9));
                                persona.setId(Integer.parseInt(rs.getString(10)));
                                con.closeConnection();
                                return persona;
                            }
                        } else {
                            errorContra = "Contraseña incorrecta";
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

    public void Modificar(Persona persona) {
        Persona p = persona;
        con.connect();
        Connection accesoDB = con.getConnection();

        try {
            PreparedStatement ps = accesoDB.prepareStatement("UPDATE Personas, Usuarios SET Personas.nombre = ?,"
                    + " Personas.apellido1 = ?, Personas.apellido2 = ?, Personas.fecha_nacimiento = ?,"
                    + " Personas.telefono = ?, Personas.direccion = ?, Usuarios.usuario = ?,"
                    + " Usuarios.contrasena = ?, Usuarios.fk_tipo = ? WHERE Personas.id = ? AND Usuarios.fk_persona = Personas.id");
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido1());
            ps.setString(3, p.getApellido2());
            ps.setDate(4, p.getFechaNac());
            ps.setString(5, p.getTelefono());
            ps.setString(6, p.getDireccion());
            ps.setString(7, p.getUsuario());
            ps.setString(8, p.getContrase());
            ps.setInt(9, p.getTipoUsu());
            ps.setInt(10, p.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR----" + e);
        }
        con.closeConnection();
        JOptionPane.showMessageDialog(registerView, "Actualizado");
    }

    public void Eliminar(Persona persona) {
        //DELETE FROM `Personas` WHERE `Personas`.`id` = 13
        Persona p = persona;
        con.connect();
        Connection accesoDB = con.getConnection();

        try {
            PreparedStatement ps = accesoDB.prepareStatement("DELETE FROM Personas, Usuarios WHERE Personas.id = ? AND Usuarios.fk_persona = Personas.id");
            ps.setInt(1, p.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ERROR----" + e);
        }
        con.closeConnection();
        JOptionPane.showMessageDialog(registerView, "Usuario "+p.getNombre()+" "+p.getApellido1()+" "+p.getApellido2()+" ELIMINADO");
    }
}
