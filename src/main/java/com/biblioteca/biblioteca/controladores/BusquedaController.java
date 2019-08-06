/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.controladores;

import com.biblioteca.biblioteca.modelos.AutorDAO;
import com.biblioteca.biblioteca.modelos.BusquedaDAO;
import com.biblioteca.biblioteca.modelos.EditorialDAO;
import com.biblioteca.biblioteca.modelos.TematicaDAO;
import com.biblioteca.biblioteca.modelos.entidades.Autor;
import com.biblioteca.biblioteca.modelos.entidades.Editorial;
import com.biblioteca.biblioteca.modelos.entidades.Libro;
import com.biblioteca.biblioteca.modelos.entidades.Tematica;
import com.biblioteca.biblioteca.vistas.JFBusqueda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cesar
 */
public class BusquedaController implements ActionListener, KeyListener {

    private BusquedaDAO BusquedaDAO;

    private JFBusqueda JFBusqueda;

    public BusquedaController() throws SQLException {

        this.BusquedaDAO = new BusquedaDAO();
        this.JFBusqueda = new JFBusqueda();

    }

    public void cargarLibros() throws SQLException {
        String[] columns = new String[]{"Id", "Titulo", "ISBN", "Fecha", "Precio", "Autor", "Editorial", "Tematica"};
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.setColumnIdentifiers(columns);

        for (Libro libro : BusquedaDAO.getAllLibros()) {

            Object[] libroR = new Object[8];
            libroR[0] = libro.getIdLibro();
            libroR[1] = libro.getTitulo();
            libroR[2] = libro.getISBN();
            libroR[3] = libro.getFecha();
            libroR[4] = libro.getPrecio();
            libroR[5] = libro.getAutor().getNombre() + " " + libro.getAutor().getApellido1();
            libroR[6] = libro.getEditorial().getNombre();
            libroR[7] = libro.getTematica().getNombre();

            modelTable.addRow(libroR);
        }
        JFBusqueda.table1.setModel(modelTable);

    }

    public void cargarTematicas() throws SQLException {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (Tematica tematica : new TematicaDAO().findAllTematicas()) {
            model.addElement(tematica);
        }

        
    }

    public void cargarEditoriales() throws SQLException {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (Editorial editorial : new EditorialDAO().findAllEditorial()) {
            model.addElement(editorial);
        }

    }

    public void cargarAutores() throws SQLException {
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        for (Autor autor : new AutorDAO().findAllAutor()) {
            model.addElement(autor);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource() == JFBusqueda.txtb) {

            String libros = JFBusqueda.txtb.getText();
            DefaultTableModel modelo = new DefaultTableModel();
            JFBusqueda.table1.setModel(modelo);            
           
           modelo.addColumn("");
        }

    }

}
