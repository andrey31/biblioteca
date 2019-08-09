/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.controladores;


import com.biblioteca.biblioteca.modelos.PrestamoDAO;
import com.biblioteca.biblioteca.modelos.entidades.Prestamo;
import com.biblioteca.biblioteca.vistas.RegistroPrestamo;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author negocio
 */
public class ControladorPrestamo  implements ActionListener{
    
    
    private Prestamo mod;
    private PrestamoDAO modC;
    private RegistroPrestamo frm;
    PrestamoDAO prestamoo = new PrestamoDAO();

    public ControladorPrestamo(Prestamo mod, PrestamoDAO modC, RegistroPrestamo frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnguardar.addActionListener(this);
        this.frm.btnmostrar.addActionListener(this);
        this.frm.btnregistrar.addActionListener(this);
        this.frm.btnSeleccionar.addActionListener(this);
        this.frm.btnactualizar.addActionListener(this);
        this.frm.btneliminar.addActionListener(this);
    }
    
    public void iniciar()
    {
        frm.setTitle("Préstamos");
        frm.setLocationRelativeTo(null);
        //frm.jTPrestamos.setVisible(false);

    }
    public void actionPerformed(ActionEvent e)
    {
        
       if(e.getSource() == frm.btnguardar){
        

          mod.setId(Integer.parseInt(frm.txtidprestamo.getText()));
          mod.setFechaprestamo(String.valueOf(frm.txtfechaprestamo.getDate()));
          mod.setFechadevolucion(String.valueOf(frm.txtfechadevolucion.getDate()));
          mod.setIdestudiante(Integer.parseInt(frm.txtidestudiante.getText()));
          mod.setISBNlibro(Integer.parseInt(frm.txtcodigolibro.getText()));
          mod.setCodigousuario(Integer.parseInt(frm.txtidusuario.getText()));

           try {
               if(modC.registrarPrestamo(mod))
               {
                   
                   JOptionPane.showMessageDialog(null,"Registro Guardado");
                   
                   Limpiar();
               }else
               {
                   esVacio();
                   JOptionPane.showMessageDialog(null, "Para continuar con el Registro LLene los campos solicitados");
                   JOptionPane.showMessageDialog(null,"Error al Guardar");
                   frm.requestFocus();
                   Limpiar();
                     
               }} catch (ParseException ex) {
               Logger.getLogger(ControladorPrestamo.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
       if(e.getSource() == frm.btnmostrar){
           try {
               cargarPrestamos();
           } catch (SQLException ex) {
               Logger.getLogger(ControladorPrestamo.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    
       if(e.getSource() == frm.btnregistrar){
         
                String id = null;
                String fecha = null;
                try {
                    if (frm.jTPrestamos.getSelectedRow() != -1) {
                        id = (String) frm.jTPrestamos.getModel().getValueAt(frm.jTPrestamos.getSelectedRow(), 1);
                        fecha = (String) frm.jTPrestamos.getModel().getValueAt(frm.jTPrestamos.getSelectedRow(), 3);
//                        DevolucionController dev = new DevolucionController();

//                        dev.datosPrestamo(fecha, id);
                        frm.dispose();
                    } else {
                        System.out.println("Seleccione un dato primero");
                    }

                } catch (Exception ex) {

                }
            }
       if(e.getSource() == frm.btnSeleccionar){
         int fila = frm.jTPrestamos.getSelectedRow();
         
         if(fila==-1)
         {
             JOptionPane.showMessageDialog(frm, "Debe seleccionar una fila");
         }
           else
         {
             int id =Integer.parseInt((String)frm.jTPrestamos.getValueAt(fila,0).toString());
//             String fechapre =(String)frm.jTPrestamos.getValueAt(fila,1).toString();
//             String fechade =(String)frm.jTPrestamos.getValueAt(fila,2).toString();
              int idestudiante =Integer.parseInt((String)frm.jTPrestamos.getValueAt(fila,3).toString());
             String ISBNlibro =(String)frm.jTPrestamos.getValueAt(fila,4).toString();
             int codusuario =Integer.parseInt((String)frm.jTPrestamos.getValueAt(fila,5).toString());
             
             frm.txtidprestamo.setText(""+id);
             frm.txtidestudiante.setText(""+idestudiante);
             frm.txtcodigolibro.setText(""+ISBNlibro);
             frm.txtidusuario.setText(""+codusuario);
             }
    }
       if(e.getSource() == frm.btnactualizar){
          
          mod.setId(Integer.parseInt(frm.txtidprestamo.getText()));
          mod.setFechaprestamo(String.valueOf(frm.txtfechaprestamo.getDate()));
          mod.setFechadevolucion(String.valueOf(frm.txtfechadevolucion.getDate()));
          mod.setIdestudiante(Integer.parseInt(frm.txtidestudiante.getText()));
          mod.setISBNlibro(Integer.parseInt(frm.txtcodigolibro.getText()));
          mod.setCodigousuario(Integer.parseInt(frm.txtidusuario.getText()));

           try {
               if(modC.modificar(mod))
               {     
                   
                   JOptionPane.showMessageDialog(null,"Dato Modificado");
 
                   Limpiar();
               }else
               {
                   JOptionPane.showMessageDialog(null, "Para continuar con el Registro LLene los campos solicitados");
                   JOptionPane.showMessageDialog(null,"Error al Guardar");
                   frm.requestFocus();
                   Limpiar();

            }  } catch (Exception ex) {
               Logger.getLogger(ControladorPrestamo.class.getName()).log(Level.SEVERE, null, ex);
           }  
       }
       if(e.getSource() == frm.btneliminar){
          mod.setId(Integer.parseInt(frm.txtidprestamo.getText()));
          mod.setFechaprestamo(String.valueOf(frm.txtfechaprestamo.getDate()));
          mod.setFechadevolucion(String.valueOf(frm.txtfechadevolucion.getDate()));
          mod.setIdestudiante(Integer.parseInt(frm.txtidestudiante.getText()));
          mod.setISBNlibro(Integer.parseInt(frm.txtcodigolibro.getText()));
          mod.setCodigousuario(Integer.parseInt(frm.txtidusuario.getText()));
            
            if(modC.eliminar(mod))
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                   Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                   Limpiar();
            }
        }
    }
   
    public void cargarPrestamos() throws SQLException {
        String[] columns = new String[]{"ID Prestamo", "Fecha Prestamo", "Fecha Devolución del Libro", "Código Estudiante", "Titulo Libro", "Código Usuario"};
        DefaultTableModel modelTable = new DefaultTableModel();
        modelTable.setColumnIdentifiers(columns);
	
 
        for (Prestamo prestamo : prestamoo.getAllPrestamos() ) {

            Object[] p = new Object[6];
            p[0] = prestamo.getId();
            p[1] = prestamo.getFechaprestamo();
            p[2] = prestamo.getFechadevolucion();
            p[3] = prestamo.getIdestudiante();
            p[4] = prestamo.getISBNlibro();
            p[5] = prestamo.getCodigousuario();
 
            modelTable.addRow(p);
        }
        this.frm.jTPrestamos.setModel(modelTable);
    }
        
     public void Limpiar()
    {
        frm.txtidprestamo.setText(null);
        frm.txtcodigolibro.setText(null);
        frm.txtidestudiante.setText(null);
        frm.txtidusuario.setText(null);
        frm.txtfechaprestamo.setCalendar(null);   
        frm.txtfechadevolucion.setCalendar(null);   
        frm.txtidusuario.setText(null);
    }
     
      

  public boolean esVacio() {
        boolean result = false;

        if ((frm.txtcodigolibro.getText()).equals(" ") || (frm.txtfechaprestamo.getDate()).equals(" ") || (frm.txtfechadevolucion.getDate()).equals(" ") || (frm.txtidestudiante.getText()).equals(" ")|| (frm.txtidprestamo.getText()).equals(" ")|| (frm.txtidusuario.getText()).equals(" ")) {
            result = true;
        }
        return result;
    }
}
 
    

