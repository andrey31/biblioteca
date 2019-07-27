package com.biblioteca.biblioteca.modelos.entidades;

import java.sql.Date;

/**
 *
 * @author msalazar02
 */
public class Devoluciones {

    private int id, fk_prestamo;
    private double multa;
    private Date fechaDevolucion;

    public Devoluciones(int id, Date fechaDevolucion, double multa, int fk_prestamo) {
        this.id = id;
        this.fk_prestamo = fk_prestamo;
        this.multa = multa;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Devoluciones() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_prestamo() {
        return fk_prestamo;
    }

    public void setFk_prestamo(int fk_prestamo) {
        this.fk_prestamo = fk_prestamo;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
