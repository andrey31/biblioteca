/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.modelos.entidades;

import java.sql.Date;

/**
 *
 * @author debian-andrey
 */
public class Libro {
    
    private int idLibro;
    private String titulo;
    private String ISBN;
    private Date fecha;
    private Double precio;
    private Autor autor;
    private Editorial editorial;
    private Tematica tematica;

    public Libro() {
    }

    public Libro(int idLibro, String titulo, String ISBN, Date fecha, Double precio, Autor autor, Editorial editorial, Tematica tematica) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.fecha = fecha;
        this.precio = precio;
        this.autor = autor;
        this.editorial = editorial;
        this.tematica = tematica;
    }
    
    

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }
    
    
}
