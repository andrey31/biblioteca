/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.controladores;

import com.biblioteca.biblioteca.modelos.LibroDAO;
import com.biblioteca.biblioteca.modelos.entidades.Libro;
import com.biblioteca.biblioteca.vistas.JFBusqueda;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cesar
 */
public class BusquedaController {
    
    private LibroDAO LibroDAO;
    
    private JFBusqueda JFBusqueda;
    
    public BusquedaController () throws SQLException{
        
        this.LibroDAO = new LibroDAO();
        this.JFBusqueda = new JFBusqueda();
        this.JFBusqueda.main();
        
       
    }

        public void cargarLibros() throws SQLException {
        String [] columns = new String [] { "Titulo", "ISBN", "Fecha", "Precio", "Autor", "Editorial", "Tematica"};
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.setColumnIdentifiers(columns);
        
        for( Libro libro : LibroDAO.getAllLibros() ){
            
            Object[] libroR = new Object[7];
            libroR[0] = libro.getTitulo();
            libroR[1] = libro.getISBN();
            libroR[2] = libro.getFecha();
            libroR[3] = libro.getPrecio();
            libroR[4] = libro.getAutor().getNombre() + " " +libro.getAutor().getApellido1();
            libroR[5] = libro.getEditorial().getNombre();
            libroR[6] = libro.getTematica().getNombre();
            
            modelTable.addRow(libroR);
        }
        JFBusqueda.table1.setModel(modelTable);
        
    }
        
    }

