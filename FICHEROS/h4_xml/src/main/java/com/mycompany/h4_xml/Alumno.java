/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.h4_xml;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw2
 */

@XmlRootElement(name = "alumno")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"nombre", "edad", "modulos"})

public class Alumno {
    
    @XmlAttribute
    private int id;
    private String nombre;
    private int edad;
    
    @XmlElementWrapper(name = "modulos")
    @XmlElement(name = "modulo")
    private List<String> modulos = new ArrayList<>();

    public Alumno() {
    }

    public Alumno(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void addModulo(String modulo){
    
        modulos.add(modulo);
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " (" + edad + " años) " + modulos;
    }
    
    
}
