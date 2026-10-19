/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.xml_bis;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

/**
 *
 * @author daw2
 */
public class MainLista {

    private static final File ARCHIVO = new File("alumnos.xml");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PropertyException, JAXBException {

        JAXBContext contexto = JAXBContext.newInstance(ListaAlumnos.class);
        ListaAlumnos alumnos = cargar(contexto);

        Alumno a1 = new Alumno(7, "Ana López", 19);
        a1.addModulo("Programación");

        Alumno a2 = new Alumno(8, "Luis Pérez", 21);
        a2.addModulo("Lenguajes de marcas");

        for (Alumno a : List.of(a1, a2)) {

            if (alumnos.addSiNoExiste(a)) {
                System.out.println("Añadido: " + a);
            }
        }

        //comprobar si existe
        if (ARCHIVO.exists()) {
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            ListaAlumnos aux = (ListaAlumnos) unmarshaller.unmarshal(ARCHIVO);

            Marshaller marshaller = contexto.createMarshaller();
            Alumno alumno = new Alumno(17, "Maya García", 24);
            alumno.addModulo("Sistemas Informaticos");
            aux.add(alumno);

            marshaller.marshal(aux, ARCHIVO);
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //instanciar siempre un unmarshaller nuevo
            Unmarshaller unmarshaller2 = contexto.createUnmarshaller();
            ListaAlumnos leidos = (ListaAlumnos) unmarshaller2.unmarshal(ARCHIVO);

            for (Alumno a : leidos.getLista()) {
                System.out.println(a);
            }

        } else {
            // Marshalling: crear varios alumnos y guardarlos

            //ListaAlumnos alumnos = new ListaAlumnos();
            alumnos.add(a1);
            alumnos.add(a2);

            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(alumnos, ARCHIVO);
            // Unmarshalling: leer el archivo y recorrer la lista
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            ListaAlumnos leidos = (ListaAlumnos) unmarshaller.unmarshal(ARCHIVO);
            for (Alumno a : leidos.getLista()) {
                System.out.println(a);
            }
        }
    }


    private static ListaAlumnos cargar(JAXBContext contexto) throws JAXBException {

        if (!ARCHIVO.exists()) {
            return new ListaAlumnos();
        }
        Unmarshaller unmarshaller = contexto.createUnmarshaller();
        return (ListaAlumnos) unmarshaller.unmarshal(ARCHIVO);
    }

    private static void guardar(JAXBContext contexto, List<ListaAlumnos> alumnos) throws PropertyException, JAXBException {
        
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(alumnos, ARCHIVO);
 
    }

}
