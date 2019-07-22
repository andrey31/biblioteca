package com.biblioteca.biblioteca.modelos;

import java.sql.*;

/**
 *
 * @author Adriel
 */
public class PersonaDAO {

    Conexion con;

    public PersonaDAO() {
        con = new Conexion();

    }

    public Persona verificaUsuario(String usuario, String contraseña) {
        Persona persona = null;
        con.connect();
        Connection accesoDB = con.getConnection();

        try {
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM Usuarios WHERE usuario=? and contrasena=?");
            ps.setString(1, usuario);
            ps.setString(2, contraseña);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                persona = new Persona();
                persona.setId(Integer.parseInt(rs.getString(1)));
                persona.setUsuario(rs.getString(2));
                persona.setContrase(rs.getString(3));
                return persona;
            }
        } catch (Exception e) {
        }
        return persona;
    }
}
