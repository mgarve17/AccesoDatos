/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.h4_xml;

import jakarta.xml.bind.*;
import java.io.File;

/**
 *
 * @author daw2
 */
public class H4_xml {

    public static void main(String[] args) throws JAXBException {
        
        JAXBContext contexto = JAXBContext.newInstance(ListaAlumnos.class);
        File archivo = new File("alumnos.xml");
        
        //MArshalling: convertir un objeto java a xml
        Alumno alumno1 = new Alumno(7, "Ana López",19);
        alumno1.addModulo("Programación");
        alumno1.addModulo("Bases de datos");
        
        Alumno alumno2 = new Alumno(8, "Luís Pérez", 21);
        alumno2.addModulo("Sistemas Informáticos");
        
        ListaAlumnos alumnos = new ListaAlumnos();
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        
        Marshaller marshaller = contexto.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(alumnos, archivo);
        
        //Unmarshalling: pasar de xml a objeto de java
        Unmarshaller unmarshaller = contexto.createUnmarshaller();
        ListaAlumnos leidos = (ListaAlumnos) unmarshaller.unmarshal(archivo);       
        
        for (Alumno alumno : leidos.getLista()) {
            System.out.println(alumno);
        }
    }
}
