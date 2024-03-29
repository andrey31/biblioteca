/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.controladores;

import com.biblioteca.biblioteca.modelos.AutorDAO;
import com.biblioteca.biblioteca.modelos.EditorialDAO;
import com.biblioteca.biblioteca.modelos.LibroDAO;
import com.biblioteca.biblioteca.modelos.TematicaDAO;
import com.biblioteca.biblioteca.modelos.entidades.Autor;
import com.biblioteca.biblioteca.modelos.entidades.Editorial;
import com.biblioteca.biblioteca.modelos.entidades.Libro;
import com.biblioteca.biblioteca.modelos.entidades.Tematica;
import com.biblioteca.biblioteca.vistas.JFLibros;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author debian-andrey
 */
public class LibroController {
    
    private LibroDAO libroDAO;
    
    private JFLibros jfLibros;
    
    boolean editar = false;
    int libroEdit = 0;
            
    public LibroController() throws SQLException {
        this.libroDAO = new LibroDAO();
        this.jfLibros = new JFLibros();
        this.jfLibros.main();
        this.jfLibros.cmbAutores.setVisible(false);
        this.jfLibros.cmbEditoriales.setVisible(false);
        this.jfLibros.cmbTematica.setVisible(false);
        this.jfLibros.lblAutorNuevo.setVisible(false);
        this.jfLibros.lblCmbEditorial.setVisible(false);
        this.jfLibros.lblCmbTematica.setVisible(false);

        
        this.cargarAutores();
        this.cargarEditoriales();
        this.cargarTematicas();
        this.cargarLibros();
        this.jfLibros.setVisible(true);
        
        this.jfLibros.btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    LibroController.this.agregarLibro();

                } catch (Exception e) {
                }
            }
        });
        this.jfLibros.tableLibros.setDefaultEditor(Object.class, null);
        this.jfLibros.rExistenteAutor.addActionListener( (ActionEvent ae) -> {this.enableCmbAutores();});
        this.jfLibros.rNuevoAutor.addActionListener( (ActionEvent ae) -> {this.enabletxtAutores();});
        this.jfLibros.rExistenteEditorial.addActionListener( (ActionEvent ae ) -> {this.enableCmbEditorial();});
        this.jfLibros.rNuevoEditorial.addActionListener( (ActionEvent ae ) -> {this.enabletxtEditorial();});
        this.jfLibros.rExistenteTematica.addActionListener( (ActionEvent ae) -> {this.enableCmbTematica();});
        this.jfLibros.rNuevoTematica.addActionListener( (ActionEvent ae) -> {this.enabletxtTematica();});
        this.jfLibros.btnEditar.addActionListener( (ActionEvent ae) -> {this.editLibros();});
        this.jfLibros.btnEliminar.addActionListener( (ActionEvent ae) -> {
            try {
                this.deleteLibros();
            } catch (SQLException ex) {
                System.out.println("error "+ ex);
            }
        });
    }
    
    public void cargarTematicas() throws SQLException {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for (Tematica tematica : new TematicaDAO().findAllTematicas()) {
            model.addElement(tematica);
        }
        
        this.jfLibros.cmbTematica.setModel(model);
    }
    public void cargarEditoriales() throws SQLException {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for (Editorial editorial : new EditorialDAO().findAllEditorial()){
            model.addElement(editorial);
        }
        this.jfLibros.cmbEditoriales.setModel(model);
        
    }
    public void cargarAutores() throws SQLException {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
         
        for (Autor autor : new AutorDAO().findAllAutor()){
           model.addElement(autor);
        }
        
        this.jfLibros.cmbAutores.setModel(model);
    }
    
    public void cargarLibros() throws SQLException {
        String [] columns = new String [] { "Titulo", "ISBN", "Fecha", "Precio", "Autor", "Editorial", "Tematica", "id"};
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.setColumnIdentifiers(columns);
        
        for( Libro libro : libroDAO.getAllLibros() ){
            
            Object[] libroR = new Object[8];
            libroR[0] = libro.getTitulo();
            libroR[1] = libro.getISBN();
            libroR[2] = libro.getFecha();
            libroR[3] = libro.getPrecio();
            libroR[4] = libro.getAutor();
            libroR[5] = libro.getEditorial();
            libroR[6] = libro.getTematica();
            libroR[7] = libro.getIdLibro();
            modelTable.addRow(libroR);
        }
        this.jfLibros.tableLibros.setModel(modelTable);
        this.jfLibros.tableLibros.getColumn("id").setPreferredWidth(0);
        this.jfLibros.tableLibros.getColumn("id").setMinWidth(0);
        this.jfLibros.tableLibros.getColumn("id").setWidth(0);
        this.jfLibros.tableLibros.getColumn("id").setMaxWidth(0);
    }
    
    private void agregarLibro() throws SQLException {
        Autor autor = new Autor();
        if (this.jfLibros.rExistenteAutor.isSelected()){
            autor = (Autor) this.jfLibros.cmbAutores.getSelectedItem();
        }
        else {
            autor.setIdAutor(0);
            autor.setNombre(this.jfLibros.txtAutorNombre.getText());
            autor.setApellido1(this.jfLibros.txtAutorA1.getText());
            autor.setApellido2(this.jfLibros.txtAutorA2.getText());
        }
        
        Editorial editorial = new Editorial();
        if (this.jfLibros.rExistenteEditorial.isSelected()){
            editorial = (Editorial) this.jfLibros.cmbEditoriales.getSelectedItem();
        }
        else {
            editorial.setIdEditorial(0);
            editorial.setNombre(this.jfLibros.txtEditoial.getText());
        }
        
        Tematica tematica = new Tematica();
        if (this.jfLibros.rExistenteTematica.isSelected()){
            tematica = (Tematica) this.jfLibros.cmbTematica.getSelectedItem();
        }
        else {
            tematica.setIdTematica(0);
            tematica.setNombre(this.jfLibros.txtTematica.getText());
        }
      
        Date fecha = Date.valueOf(this.jfLibros.inputFecha.getDate());
        
        int libroInt = 0;
        Libro libro = new Libro( 0, this.jfLibros.txtTitulo.getText(), this.jfLibros.txtISBN.getText(), fecha,
                Double.parseDouble(this.jfLibros.txtPrecio.getText()), autor, editorial, tematica);
        
        if (this.editar == false){
            libroInt = this.libroDAO.saveLibro(libro);
        }
        else {
            libroInt = this.libroDAO.updateLibro(libroEdit, libro);
        }
        
        if(libroInt == 1) {
            System.out.println("Libro agregado");
            this.editar = false;
            this.cargarLibros();
            this.clearFields();
            this.cargarEditoriales();
            this.cargarTematicas();
            this.cargarAutores();
        }
        else {
            System.out.println("Libro no agregado");
        }
    }

//    De aquí para abajo oculta los combobox o textfield según el radio seleccionado
    private void enableCmbAutores() {
        if (this.jfLibros.rExistenteAutor.isSelected()) {
            this.jfLibros.rNuevoAutor.setSelected(false);
            this.jfLibros.cmbAutores.setVisible(true);
            this.jfLibros.lblAutorNuevo.setVisible(true);
            this.jfLibros.panelAutor.setVisible(false);
            

        }
    }
    private void enabletxtAutores() {
        if(this.jfLibros.rNuevoAutor.isSelected()){
            this.jfLibros.rExistenteAutor.setSelected(false);
            this.jfLibros.cmbAutores.setVisible(false);
            this.jfLibros.txtAutorNombre.setVisible(true);
            this.jfLibros.txtAutorA1.setVisible(true);
            this.jfLibros.txtAutorA2.setVisible(true);
            this.jfLibros.lblNombre1.setVisible(true);
            this.jfLibros.lblApellido1.setVisible(true);
            this.jfLibros.lblApellido2.setVisible(true);
            this.jfLibros.panelAutor.setVisible(true);
            this.jfLibros.lblAutorNuevo.setVisible(false);
        }
    }

    private void enableCmbEditorial() {
        if(this.jfLibros.rExistenteEditorial.isSelected()){
            this.jfLibros.rNuevoEditorial.setSelected(false);
            this.jfLibros.cmbEditoriales.setVisible(true);
            this.jfLibros.txtEditoial.setVisible(false);
            this.jfLibros.lblCmbEditorial.setVisible(true);
            this.jfLibros.lblTxtEditorial.setVisible(false);
            this.jfLibros.separadorEditorial.setVisible(false);
        }
    }

    private void enabletxtEditorial() {
        if(this.jfLibros.rNuevoEditorial.isSelected()){
            this.jfLibros.rExistenteEditorial.setSelected(false);
            this.jfLibros.cmbEditoriales.setVisible(false);
            this.jfLibros.txtEditoial.setVisible(true);
            this.jfLibros.lblCmbEditorial.setVisible(false);
            this.jfLibros.lblTxtEditorial.setVisible(true);
            this.jfLibros.separadorEditorial.setVisible(true);
        }
    }

    private void enableCmbTematica() {
        if (this.jfLibros.rExistenteTematica.isSelected()){
            this.jfLibros.rNuevoTematica.setSelected(false);
            this.jfLibros.cmbTematica.setVisible(true);
            this.jfLibros.txtTematica.setVisible(false);
            this.jfLibros.lblCmbTematica.setVisible(true);
            this.jfLibros.lblTxtTematica.setVisible(false);
            this.jfLibros.separadorTematica.setVisible(false);
        }
    }

    private void enabletxtTematica() {
        if (this.jfLibros.rNuevoTematica.isSelected()){
            this.jfLibros.rExistenteTematica.setSelected(false);
            this.jfLibros.cmbTematica.setVisible(false);
            this.jfLibros.txtTematica.setVisible(true);
            this.jfLibros.lblCmbTematica.setVisible(false);
            this.jfLibros.lblTxtTematica.setVisible(true);
        }
    }
    
    private void clearFields() {
        JTextField temp = null;
        
        for (Component c : this.jfLibros.jPanel1.getComponents()) {
            if (c.getClass().toString().contains("javax.swing.JTextField")) {
                temp = (JTextField) c;
                temp.setText("");
            }

        }
    }

    public void setId_libro(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editLibros() {
        int rowSelect = this.jfLibros.tableLibros.getSelectedRow();
        
        if (rowSelect > -1){
            String titulo = (String) this.jfLibros.tableLibros.getModel().getValueAt(rowSelect, 0);
            String isbn = (String) this.jfLibros.tableLibros.getModel().getValueAt(rowSelect, 1);
            Date fecha = (Date) this.jfLibros.tableLibros.getModel().getValueAt(rowSelect, 2);
            Double precio = (Double) this.jfLibros.tableLibros.getModel().getValueAt(rowSelect, 3);
            this.jfLibros.txtTitulo.setText(titulo);
            this.jfLibros.txtISBN.setText(isbn);
            this.jfLibros.inputFecha.setDate(fecha.toLocalDate());
            this.jfLibros.txtPrecio.setText(Double.toString(precio));
//            this.jfLibros.cmbAutores.setSelectedItem((Autor) this.jfLibros.tableLibros.getModel().getValueAt(rowSelect, 4));
            this.jfLibros.rExistenteAutor.setSelected(true);
            this.enableCmbAutores();
            this.jfLibros.rExistenteEditorial.setSelected(true);
            this.enableCmbEditorial();
            this.jfLibros.rExistenteTematica.setSelected(true);
            this.enableCmbTematica();
            this.libroEdit = (int) this.jfLibros.tableLibros.getModel().getValueAt(rowSelect, 7);
            this.editar = true;
        }
       
        
    }

    private void deleteLibros() throws SQLException {
        int rowSelect = this.jfLibros.tableLibros.getSelectedRow();
        
        int idLibro = 0;
        if(rowSelect > -1 ) {
            idLibro = (int) this.jfLibros.tableLibros.getModel().getValueAt(rowSelect, 7);
            libroDAO.deleteLibro(idLibro);
            
            this.cargarLibros();
            this.clearFields();
//            this.cargarEditoriales();
//            this.cargarTematicas();
//            this.cargarAutores();
        }
        
    }

    
}