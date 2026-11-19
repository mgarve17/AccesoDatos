package com.daw.prog.preguntastest;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author daw2
 */
public class AccesoBD {

    private static final String FICHERO = "/db.properties";
    private static final Properties PROPS = cargarPropiedades();
    private static final String URL = obligatoria(PROPS, "db.url");//llamar a metodo obligatoria que sabe dios que hace
    private static final String USUARIO = obligatoria(PROPS, "db.user");
    private static final String PASSWORD = PROPS.getProperty("db.password", "").trim();

    private AccesoBD() {
    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USUARIO, PASSWORD);

    }

    public static Properties cargarPropiedades() {

        Properties p = new Properties();

        try (InputStream input = AccesoBD.class.getResourceAsStream(FICHERO)) {

            if (input == null) {
                throw new IllegalStateException("No se pudieron cargar las propiedades del fichero " + FICHERO);
            }

            p.load(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (IOException ex) {
            System.getLogger(AccesoBD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return p;
    }

    public static String obligatoria(Properties props, String clave) {

        String valor = props.getProperty(clave);
        if (valor == null || valor.isBlank()) {
            throw new IllegalStateException("falta la propiedad " + clave+ "en " + FICHERO);
        }

        return valor.trim();
    }

}
