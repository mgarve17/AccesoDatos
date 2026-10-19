/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xml_bis;

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
    public boolean existe(int id){
        
        boolean valido = false;
    
        for (Alumno alumno : lista) {
            if (alumno.getId() == id) {
                
                valido = true;
            }
        }
        return valido;
    }

   public boolean addSiNoExiste(Alumno a) {
        
        boolean valido = false;
        
        if (existe(a.getId())) {
            valido = true;
        }
        
        lista.add(a);
        return valido;
    }
   
   public boolean eliminar(int id){
 
       return lista.removeIf( alumno -> alumno.getId() == id);
   }
   
   public List<Alumno> buscarPorModulo(String modulo){
   
       List<Alumno> alumnos = new ArrayList<>();
       
       //recorrer todos los alumnos de la lista
       for (Alumno alumno : lista) {
           
          List<String> modulos = alumno.getModulos();
          
          //comparar modulos
           for (String modulo1 : modulos) {
               if (modulo1.equalsIgnoreCase(modulo)) {
                   //añadir alumno que tenga el modulo
                   alumnos.add(alumno);
               }
           }
       }
       
       return alumnos;
   }
    
}
