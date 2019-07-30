
package com.biblioteca.biblioteca.modelos.entidades;

import java.sql.Date;

/**
 *
 * @author Adriel
 */
public class Persona {
    int id;
    String nombre,apellido1,apellido2;
    Date fechaNac;
    String telefono, direccion, usuario, contrase;
    int tipoUsu;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido1, String apellido2, Date fechaNac, String telefono, String direccion, String usuario, String contrase, int tipoUsu) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrase = contrase;
        this.tipoUsu = tipoUsu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrase() {
        return contrase;
    }

    public void setContrase(String contrase) {
        this.contrase = contrase;
    }

     public int getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(int tipoUsu) {
        this.tipoUsu = tipoUsu;
    }
    
    
}
