/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.modelos;

/**
 *
 * @author frubilar
 */
public class Local {

    Integer id = null;
    String nombre = null;
    Integer telefono = null;
    String direccion = null;
    Integer numeroLocal = null;

    public Local() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumeroLocal() {
        return numeroLocal;
    }

    public void setNumeroLocal(Integer numeroLocal) {
        this.numeroLocal = numeroLocal;
    }
    
    
}
