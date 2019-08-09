/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.modelos.entidades;

/**
 *
 * @author cesar
 */
public class Prestamo {
    
     private int id;
    private String fechaprestamo;
    private String fechadevolucion;
    private int idestudiante;
    private int ISBNlibro;
    private int codigousuario; 

    public Prestamo(int id, String fechaprestamo, String fechadevolucion, int idestudiante, int ISBNlibro, int codigousuario) {
        this.id = id;
        this.fechaprestamo = fechaprestamo;
        this.fechadevolucion = fechadevolucion;
        this.idestudiante = idestudiante;
        this.ISBNlibro = ISBNlibro;
        this.codigousuario = codigousuario;
    }

    
      
   public Prestamo() {
     }

    public int getISBNlibro() {
        return ISBNlibro;
    }

    public void setISBNlibro(int ISBNlibro) {
        this.ISBNlibro = ISBNlibro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(String fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public String getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

   

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

     
    public int getCodigousuario() {
        return codigousuario;
    }

    public void setCodigousuario(int codigousuario) {
        this.codigousuario = codigousuario;
    }
}
