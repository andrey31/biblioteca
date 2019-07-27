package com.biblioteca.biblioteca.controladores;

import com.biblioteca.biblioteca.modelos.DevolucionesDAO;
import com.biblioteca.biblioteca.modelos.entidades.Devoluciones;
import com.biblioteca.biblioteca.vistas.JFDevoluciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/*
 * @author msalazar02
 */
public class DevolucionController {

    private DevolucionesDAO devolucionesDAO;
    private JFDevoluciones jfDev;
    private Devoluciones dev;

    public DevolucionController() throws SQLException {
        this.jfDev = new JFDevoluciones();
        datosPrestamo("2019-07-01", "4");
        cargarDevolucion();
        jfDev.setVisible(true);

        this.jfDev.btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ingresarDevolucion();
                    cargarDevolucion();
                } catch (Exception ex) {

                }
            }
        });
        this.jfDev.btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                } catch (Exception ex) {

                }
            }
        });
    }

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

    public void ingresarDevolucion() throws Exception {
        devolucionesDAO = new DevolucionesDAO();

        dev = new Devoluciones();
        dev.setFechaDevolucion(this.jfDev.dtpFechaDev.getDate() + "");
        dev.setFk_prestamo(Integer.parseInt(this.jfDev.lbIdPrestamo.getText()));
        dev.setMulta(Double.parseDouble(this.jfDev.txtMulta.getText()));

        devolucionesDAO.saveDevolucion(dev);
    }

    public void datosPrestamo(String fecha, String id) {
        this.jfDev.txtFechaProp.setText(fecha);
        this.jfDev.lbIdPrestamo.setText(id);
    }
    /* public double calcularMulta() {
        double multa = 0;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date fechaInicial = (Date) dateFormat.parse("2016-02-14");
            Date fechaFinal = (Date) dateFormat.parse("2016-03-22");

            multa = (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000);

            //System.out.println("Hay " + dias + " dias de diferencia");
        } catch (ParseException ex) {
            Logger.getLogger(DevolucionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return multa;
    }*/
}
