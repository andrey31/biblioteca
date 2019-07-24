/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.modelos;

import com.biblioteca.biblioteca.modelos.entidades.Editorial;
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
public class EditorialDAO {
    
    private Conexion conexion = new Conexion();
    
    public int saveEditorial(Editorial editorial) throws SQLException {
        
        conexion.connect();
        Connection connection = conexion.getConnection();
        
        String query = "INSERT INTO Editoriales (nombre) VALUES (?)";
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, editorial.getNombre());
        ps.executeUpdate();
        
        int insert = 0;
        
        ResultSet rs = ps.getGeneratedKeys();
        
        //Devuelve el id de la editorial insertada
        if (rs.next()){
            insert = rs.getInt(1);
        }
        
        conexion.closeConnection();
        return insert;
        
    }
    public List<Editorial> findAllEditorial() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        
        String query = "SELECT * from Editoriales";
        
        List<Editorial> editoriales = new ArrayList<>();
        
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        
        while(rs.next()) {
            editoriales.add( new Editorial (rs.getInt("id_editorial"), rs.getString("nombre")));
        }
        conexion.closeConnection();
        return editoriales;
    }
    
}
