/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.h4_xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw2
 */

@XmlRootElement (name = "alumnos")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaAlumnos {
    
    @XmlElement(name = "alumno")
    private List<Alumno> lista = new ArrayList<>();
    
    public void add(Alumno alumno){
    
        lista.add(alumno);
    }
    
    public List<Alumno> getLista(){
    
        return lista;
    }
    
}
