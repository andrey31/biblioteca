/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.modelos.entidades;

/**
 *
 * @author debian-andrey
 */
public class Tematica {
    
    private int idTematica;    
    private String nombre;

    public Tematica() {
    }

    public Tematica(int idTematica, String nombre) {
        this.idTematica = idTematica;
        this.nombre = nombre;
    }
    
    public int getIdTematica() {
        return idTematica;
    }

    public void setIdTematica(int idTematica) {
        this.idTematica = idTematica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }   
}