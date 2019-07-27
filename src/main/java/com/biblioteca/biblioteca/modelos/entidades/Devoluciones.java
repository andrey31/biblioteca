package com.biblioteca.biblioteca.modelos.entidades;

import java.sql.Date;

/**
 *
 * @author msalazar02
 */
public class Devoluciones {

    private int id, fk_prestamo;
    private double multa;
    private String fechaDevolucion, fechaPropuesta;

    public Devoluciones(int id, String fechaPropuesta, String fechaDevolucion, double multa, int fk_prestamo) {
        this.id = id;
        this.fk_prestamo = fk_prestamo;
        this.multa = multa;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaPropuesta = fechaPropuesta;
    }

    public Devoluciones(int id, String fechaDevolucion, double multa, int fk_prestamo) {
        this.id = id;
        this.fk_prestamo = fk_prestamo;
        this.multa = multa;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getFechaPropuesta() {
        return fechaPropuesta;
    }

    public void setFechaPropuesta(String fechaPropuesta) {
        this.fechaPropuesta = fechaPropuesta;
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

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

}
