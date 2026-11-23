/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repasoconcurso;

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
 * @author dam206@iesmhp.local
 */
public class ConexionBD {

    private static final String FICHERO = "/db.properties";
    private static final Properties PROPS = cargarPropiedades();//esto tiene que estar definido antes de los atributos de debajo
    private static final String URL = obligatoria(PROPS, "db.url");
    private static final String USER = obligatoria(PROPS, "db.user");
    private static final String PASSWORD = PROPS.getProperty("db.password", "").trim();
    
    

    public static Connection getConn() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
    
    public static Properties cargarPropiedades() {

        Properties prop = new Properties();

        try (InputStream input = ConexionBD.class.getResourceAsStream(FICHERO)) {
            if (input == null) {
                throw new IllegalAccessException("");
            }
            prop.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException ex) {
            System.out.println("");
        } catch (IllegalAccessException ex) {
            System.out.println("");
        }
        return prop;
    }

    public static String obligatoria(Properties prop, String clave) {

        String valor = prop.getProperty(clave);

        if (valor == null || valor.isBlank()) {

            throw new IllegalStateException();
        }

        return valor.trim();
    }
}
