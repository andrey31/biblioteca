/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.modelos;

import com.biblioteca.biblioteca.modelos.entidades.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author debian-andrey
 */
public class AutorDAO {
    
    private Conexion conexion = new Conexion();
    
    public int saveAutor(Autor autor) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        
        String query = "INSERT INTO Autores (nombre, apellido1, apellido2) VALUES (?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, autor.getNombre());
        ps.setString(2, autor.getApellido1());
        ps.setString(3, autor.getApellido2());
        
        ps.executeUpdate();
        
        int insert = 0;
        
        ResultSet rs = ps.getGeneratedKeys();
        
        //Devuelve el id del autor insertado
        if (rs.next()){
            insert = rs.getInt(1);
        }
        
        conexion.closeConnection();
        return insert;
        
    }
    
    public List<Autor> findAllAutor() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        
        String query = "SELECT * from Autores";
        
        List<Autor> autores = new ArrayList<>();
        
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        
        while(rs.next()) {
            autores.add( new Autor(rs.getInt("id_autor"), 
                            rs.getString("nombre"), 
                            rs.getString("apellido1"), 
                            rs.getString("apellido2")));
        }
        conexion.closeConnection();
        return autores;
    }
    
}
