package com.biblioteca.biblioteca.controladores;

import com.biblioteca.biblioteca.modelos.DevolucionesDAO;
import com.biblioteca.biblioteca.modelos.entidades.Devoluciones;
import com.biblioteca.biblioteca.vistas.JFDevoluciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * @author msalazar02
 */
public class DevolucionController {

    private DevolucionesDAO devolucionesDAO;
    private JFDevoluciones jfDev;
    private Devoluciones dev;
    private int idDev = 0;
    private boolean actualizar = false;

    public DevolucionController() throws SQLException {
        this.jfDev = new JFDevoluciones();
        Paneles(true, false);
        datosPrestamo("2019-07-01", "7");
        cargarDevolucion();
        jfDev.setVisible(true);

        this.jfDev.btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    devolucionesDAO = new DevolucionesDAO();
                    if (!devolucionesDAO.devoluciónExiste(Integer.parseInt(jfDev.lbIdPrestamo.getText()))) {

                        ingresarDevolucion();
                        cargarDevolucion();
                        limpiarCampos();
                    } else {
                        limpiarCampos();
                        JOptionPane.showMessageDialog(null, "Devolución ya ingresada");
                    }

                } catch (Exception ex) {

                }
            }
        });
        this.jfDev.btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (actualizar == false) {
                        cargarDatosUpdate();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        this.jfDev.btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (actualizar) {
                        updateDevolucion();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        this.jfDev.btnCancelarUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (actualizar) {
                        cancelarUpdate();
                    }
                } catch (Exception ex) {
                }
            }
        });
    }

    //Carga todos los registros en la tabla
    public void cargarDevolucion() throws SQLException {
        devolucionesDAO = new DevolucionesDAO();
        String[] columns = new String[]{"id", "Fecha propuesta", "Fecha devolución", "Multa", "Préstamo"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        for (Devoluciones dev : devolucionesDAO.findAllDevoluciones()) {

            Object[] devolucion = new Object[5];
            devolucion[0] = dev.getId();
            devolucion[1] = dev.getFechaPropuesta();
            devolucion[2] = dev.getFechaDevolucion();
            devolucion[3] = dev.getMulta();
            devolucion[4] = dev.getFk_prestamo();

            model.addRow(devolucion);
        }
        this.jfDev.tbTabla.setModel(model);

    }

    //Nuevo registro de devoluciones
    public void ingresarDevolucion() throws Exception {
        devolucionesDAO = new DevolucionesDAO();

        dev = new Devoluciones();
        dev.setFechaDevolucion(this.jfDev.dtpFechaDev.getDate() + "");
        dev.setFk_prestamo(Integer.parseInt(this.jfDev.lbIdPrestamo.getText()));
        dev.setMulta(Double.parseDouble(this.jfDev.txtMulta.getText()));

        devolucionesDAO.saveDevolucion(dev);
        limpiarCampos();
    }

    //Carga los datos en los campos para hacer el update
    public void cargarDatosUpdate() {
        JOptionPane.showMessageDialog(null, "Hola");
        if (this.jfDev.tbTabla.getSelectedRow() != -1) {

            dev = new Devoluciones();
            idDev = (int) this.jfDev.tbTabla.getModel().getValueAt(this.jfDev.tbTabla.getSelectedRow(), 0);
            this.jfDev.txtFechaProp.setText((String) this.jfDev.tbTabla.getModel().getValueAt(this.jfDev.tbTabla.getSelectedRow(), 1));
            this.jfDev.dtpFechaDev.setText((String) this.jfDev.tbTabla.getModel().getValueAt(this.jfDev.tbTabla.getSelectedRow(), 2));
            this.jfDev.txtMulta.setText(this.jfDev.tbTabla.getModel().getValueAt(this.jfDev.tbTabla.getSelectedRow(), 3) + "");
            this.jfDev.lbIdPrestamo.setText(this.jfDev.tbTabla.getModel().getValueAt(this.jfDev.tbTabla.getSelectedRow(), 4) + "");
            actualizar = true;
            jfDev.lbError.setText("");
            Paneles(false, true);
        }
        if (this.jfDev.tbTabla.getSelectedRow() == -1) {
            jfDev.lbError.setText("Elija la fila de la tabla que sea actualizar");
        }

    }

    //Actualiza el registro
    public void updateDevolucion() throws SQLException {
        if (idDev != 0) {
            dev.setFechaDevolucion(this.jfDev.dtpFechaDev.getText());
            dev.setId(idDev);
            dev.setMulta(Double.parseDouble(this.jfDev.txtMulta.getText()));

            devolucionesDAO.updateDevolucion(dev);
        }

        idDev = 0;
        actualizar = false;
        limpiarCampos();
        Paneles(true, false);
    }

    //Captura los datos del módulo de préstamo
    public void datosPrestamo(String fecha, String id) {
        this.jfDev.txtFechaProp.setText(fecha);
        this.jfDev.lbIdPrestamo.setText(id);
    }

    public void limpiarCampos() {
        this.jfDev.dtpFechaDev.setText("");
        this.jfDev.txtMulta.setText("0");
        this.jfDev.lbIdPrestamo.setText("");
        jfDev.lbError.setText("");
    }

    public void Paneles(boolean editar, boolean actualizar) {
        jfDev.pnEditar.setVisible(editar);
        jfDev.pnActualizar.setVisible(actualizar);
        jfDev.tbTabla.enable(editar);

    }

    public void cancelarUpdate() throws SQLException {
        Paneles(true, false);
        limpiarCampos();

    }

    /*public double calcularMulta() {
        double multa = 0;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date fechaInicial = (Date) dateFormat.parse("2016-02-14");
            Date fechaFinal = (Date) dateFormat.parse("2016-03-22");

            multa = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);

            //System.out.println("Hay " + dias + " dias de diferencia");
        } catch (ParseException ex) {

        }
        return multa;
    }*/
}
