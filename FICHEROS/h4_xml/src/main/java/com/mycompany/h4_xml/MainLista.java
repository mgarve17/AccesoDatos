/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.h4_xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 *
 * @author daw2
 */
public class MainLista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PropertyException, JAXBException {
        JAXBContext contexto = JAXBContext.newInstance(ListaAlumnos.class);
        File archivo = new File("alumnos.xml");
// Marshalling: crear varios alumnos y guardarlos
        Alumno a1 = new Alumno(7, "Ana López", 19);
        a1.addModulo("Programación");
        a1.addModulo("Bases de datos");
        
        Alumno a2 = new Alumno(8, "Luis Pérez", 21);
        a2.addModulo("Lenguajes de marcas");
        
        ListaAlumnos alumnos = new ListaAlumnos();
        alumnos.add(a1);
        alumnos.add(a2);
        
        Marshaller marshaller = contexto.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(alumnos, archivo);
// Unmarshalling: leer el archivo y recorrer la lista
        Unmarshaller unmarshaller = contexto.createUnmarshaller();
        ListaAlumnos leidos = (ListaAlumnos) unmarshaller.unmarshal(archivo);
        for (Alumno a : leidos.getLista()) {
            System.out.println(a);
        }
    }

}
