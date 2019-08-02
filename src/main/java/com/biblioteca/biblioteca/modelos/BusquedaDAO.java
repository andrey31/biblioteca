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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cesar
 */
public class BusquedaDAO {
    
    private Conexion conexion = new Conexion();
    private AutorDAO autorDAO = new AutorDAO();
    private EditorialDAO editorialDAO = new EditorialDAO();
    private TematicaDAO tematicaDAO = new TematicaDAO();
    
    public Integer saveLibro(Libro libro) throws SQLException {
        
        conexion.connect();
        
        Connection connection = conexion.getConnection();
        
        int fkAutor = libro.getAutor().getIdAutor();
        int fkEditorial = libro.getEditorial().getIdEditorial();
        int fkTematica = libro.getTematica().getIdTematica();
        
        if(fkAutor == 0){
            fkAutor = autorDAO.saveAutor(libro.getAutor());
        }
        if(fkEditorial == 0){
            fkEditorial = editorialDAO.saveEditorial(libro.getEditorial());
        }
        if(fkTematica == 0){
            fkTematica = tematicaDAO.saveTematica(libro.getTematica());
        }
       
     return null;   
    }

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
}

    