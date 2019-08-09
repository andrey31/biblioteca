/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.controladores;

import com.biblioteca.biblioteca.modelos.AutorDAO;
import com.biblioteca.biblioteca.modelos.BusquedaDao;
import com.biblioteca.biblioteca.modelos.EditorialDAO;
import com.biblioteca.biblioteca.modelos.TematicaDAO;
import com.biblioteca.biblioteca.modelos.entidades.Autor;
import com.biblioteca.biblioteca.modelos.entidades.Editorial;
import com.biblioteca.biblioteca.modelos.entidades.Libro;
import com.biblioteca.biblioteca.modelos.entidades.Tematica;
import com.biblioteca.biblioteca.vistas.JFBusqueda;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cesar
 */
public class BusquedaControl {
    
    private BusquedaDao BusquedaDao;
    private JFBusqueda JFBusqueda;
    
    public BusquedaControl ()throws SQLException {
        this.BusquedaDao = new BusquedaDao();
        this.JFBusqueda = new JFBusqueda();
        
        this.cargarLibros();
        this.JFBusqueda.setVisible(true);
    }
    public void cargarLibros() throws SQLException {
        String [] columns = new String [] { "Titulo", "ISBN", "Fecha", "Precio", "Autor", "Editorial", "Tematica"};
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.setColumnIdentifiers(columns);
        
        for( Libro libro : BusquedaDao.getAllLibros() ){
            
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
        this.JFBusqueda.table1.setModel(modelTable);   
    }

    
}
