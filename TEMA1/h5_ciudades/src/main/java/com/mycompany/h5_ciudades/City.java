/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.h5_ciudades;

import java.io.Serializable;

/**
 *
 * @author daw2
 */
public class City implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String codPais;
    private String provincia;
    private int poblacion;

    public City(int id, String nombre, String codPais, String provincia, int poblacion) {
        this.id = id;//MIRAR PARA GENERAR EL ID SEGUN EL ULTIMO EXISTENTE????
        this.nombre = nombre;
        this.codPais = codPais;
        this.provincia = provincia;
        this.poblacion = poblacion;
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

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", nombre=" + nombre + ", codPais=" + codPais + ", provincia=" + provincia + ", poblacion=" + poblacion + '}';
    }
    
    
}
