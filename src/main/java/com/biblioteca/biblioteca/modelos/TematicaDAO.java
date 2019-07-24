/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.modelos;

import com.biblioteca.biblioteca.modelos.entidades.Tematica;
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
public class TematicaDAO {
    
    private Conexion conexion = new Conexion();
    
    public int saveTematica(Tematica tematica) throws SQLException {
        
        conexion.connect();
        Connection connection = conexion.getConnection();
        
        String query = "INSERT INTO Tematicas (nombre) VALUES (?)";
        PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, tematica.getNombre());
        ps.executeUpdate();
        
        int insert = 0;
        
        ResultSet rs = ps.getGeneratedKeys();
        
        //Devuelve el id de la tematica insertada
        if (rs.next()){
            insert = rs.getInt(1);
        }
        
        conexion.closeConnection();
        return insert;
        
    }
    
    public List<Tematica> findAllTematicas() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        
        String query = "SELECT * from Tematicas";
        
        List<Tematica> tematicas = new ArrayList<>();
        
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        
        while(rs.next()) {
            tematicas.add( new Tematica (rs.getInt("id_tematica"), rs.getString("nombre")));
        }
        conexion.closeConnection();
        return tematicas;
    }
}
