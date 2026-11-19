/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author daw2
 */
public class AccesoBD {

    private static final String FICHERO = "/db.properties";
    private static final Properties PROPS = cargarPropiedades();
    private static final String URL = obligatoria(PROPS, "db.user");
    private static final String USER= obligatoria(PROPS,"db.user");
    private static final String PASSWORD = obligatoria(PROPS, "db.password");
    

    private AccesoBD() {}
    
    public static Connection getConnection() throws SQLException{
    
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static Properties cargarPropiedades(){
    
        Properties prop = new Properties();
        
        try(InputStream input = AccesoBD.class.getResourceAsStream(FICHERO)){
        
            if (input == null) {
                
                throw new IllegalStateException("No se pueden cargar las propiedades de " + FICHERO);
            }
            
            prop.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException ex) {
            System.getLogger(AccesoBD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
        return prop;
    }
    
    public static String obligatoria(Properties prop, String clave){
    
        String valor = prop.getProperty(clave);
        
        if (valor == null || valor.isBlank()) {
            throw new IllegalStateException("No existe " + clave + "en " + FICHERO);
        }
        
        return valor.trim();
    }
}


