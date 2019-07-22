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
                
                persona.setUsuario(rs.getString(2));
                persona.setContrase(rs.getString(3));
                persona.setId(Integer.parseInt(rs.getString(4)));
                persona.setTipoUsu(Integer.parseInt(rs.getString(5)));
                
                ps = accesoDB.prepareStatement("SELECT * FROM Personas WHERE id=?");
                
                ps.setString(1, String.valueOf(persona.getId()));
                rs = ps.executeQuery();
                if (rs.next()){
                    persona.setNombre(rs.getString(2));
                    persona.setApellido1(rs.getString(3));
                    persona.setApellido2(rs.getString(4));
                    persona.setFechaNac(rs.getString(5));
                    persona.setTelefono(rs.getString(6));
                    persona.setDireccion(rs.getString(7));
                    return persona;
                }
                
                return persona;
            }
        } catch (Exception e) {
        }
        return persona;
    }
}
