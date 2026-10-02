/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.h5_ciudades;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author daw2
 */
public class City implements Serializable /*Comparable<City>*/ {

    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private String codPais;
    private String provincia;
    private int poblacion;

    public City() {
    }

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

    
    //SUSTITUIR LOS METODOS DE ABAJO POR COMPARATOR EN
    
    
//    @Override
//    public boolean equals(Object obj) {
//
////        si obj y this NO referencian al mismo objeto return false
////        si obj no es una instancia de city return false
////        si obj es una instancia de ciudad y su nombre y codigo de pais coinciden return true
//        return this == obj || (obj instanceof City ciudad && Objects.equals(nombre, ciudad.nombre)
//                && Objects.equals(codPais, ciudad.codPais));
//    }
//
//    //hashcode para la comparacion
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(nombre, codPais);
//    }
//
//    @Override
//    public int compareTo(City otra) {
//        
//        //1. comparar nombre de las ciudades
//        //2. compara el codigo del pais
//        //3. compara el objeto actual con el objeto recibido por parametro
//        return Comparator.comparing(City::getNombre).thenComparing(City::getCodPais).compare(this, otra);
//    }
}
