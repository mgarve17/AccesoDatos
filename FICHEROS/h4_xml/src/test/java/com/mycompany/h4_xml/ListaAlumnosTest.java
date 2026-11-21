/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.h4_xml;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author daw2
 */
public class ListaAlumnosTest {
    
    private ListaAlumnos alumnos;
    
    public ListaAlumnosTest() {
    }

    
    @BeforeEach
    public void setUp() {
        
        alumnos = new ListaAlumnos();
        //llenar la lista
        
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    void existeDevuelveTrueSiCOincideId(){
    
        //assertTrue(alumnos.Existe(7));
    }

    /**
     * Test of add method, of class ListaAlumnos.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Alumno alumno = null;
        ListaAlumnos instance = new ListaAlumnos();
        instance.add(alumno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLista method, of class ListaAlumnos.
     */
    @Test
    public void testGetLista() {
        System.out.println("getLista");
        ListaAlumnos instance = new ListaAlumnos();
        List<Alumno> expResult = null;
        List<Alumno> result = instance.getLista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
