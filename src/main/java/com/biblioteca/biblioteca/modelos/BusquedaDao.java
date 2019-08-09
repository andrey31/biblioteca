/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.modelos;

import com.biblioteca.biblioteca.modelos.entidades.Autor;
import com.biblioteca.biblioteca.modelos.entidades.Editorial;
import com.biblioteca.biblioteca.modelos.entidades.Libro;
import com.biblioteca.biblioteca.modelos.entidades.Tematica;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar
 */
public class BusquedaDao {
    
    private Conexion conexion = new Conexion();
    
    public List<Libro> getAllLibros() throws SQLException{
        
        conexion.connect();
        Connection connection = conexion.getConnection();
        
        String query = "SELECT l.id_libro, l.titulo, l.ISBN, l.fecha, l.precio, "
                + "a.nombre as nombre_autor, a.apellido1, a.apellido2, "
                + "e.nombre as nombre_editorial, "
                + "t.nombre as nombre_tematica "
                + "FROM Libros as l INNER JOIN Autores as a ON a.id_autor = l.fk_autor "
                + "INNER JOIN Editoriales as e ON e.id_editorial = l.fk_editorial "
                + "INNER JOIN Tematicas as t ON t.id_tematica = l.fk_tematica ORDER BY l.id_libro";
        
        ResultSet rs = connection.prepareStatement(query).executeQuery();
        
        List<Libro> libros = new ArrayList<>();
        
        while(rs.next()){
        
            Autor autor = new Autor(0, rs.getString("nombre_autor"), rs.getString("apellido1"), rs.getString("apellido2"));
            Editorial editorial = new Editorial(0, rs.getString("nombre_editorial"));
            Tematica tematica = new Tematica(0, rs.getString("nombre_tematica"));
            
            Libro libro = new Libro(
                    rs.getInt("id_libro"),
                    rs.getString("titulo"),
                    rs.getString("ISBN"),
                    rs.getDate("fecha"),
                    rs.getDouble("precio"),
                    autor,
                    editorial,
                    tematica
            );
            libros.add(libro); 
        }
        conexion.closeConnection();
        return libros;
    }

    public ArrayList<Libro>buscarporTitulo(String Titulo){
     
        ArrayList<Libro> listaTi = new ArrayList();
        Libro libro;
        try {
            Connection connection = conexion.getConnection();
            CallableStatement cs = connection.prepareCall("Buscar Libro(?)");
            cs.setString(1, Titulo);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                libro = new Libro ();
                libro.setTitulo(rs.getString(1));
                libro.setISBN(rs.getString(2));
                libro.setFecha(rs.getDate(3));
                libro.setPrecio(rs.getDouble(4));
                Autor autor = null;
                libro.setAutor(autor);
                Editorial editorial = null;
                libro.setEditorial(editorial);
                Tematica tematica = null;
                libro.setTematica(tematica);
                
               listaTi.add(libro);
            }
        } catch (Exception e) {
        }
        return listaTi;
    }
}
