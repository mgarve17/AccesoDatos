/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.prog.preguntastest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw2@iesmhp.local
 */
public class PreguntasDAO implements Repositorio<Pregunta> {

    private Connection getConnection() throws SQLException {

        return AccesoBD.getConnection();

    }

    @Override
    public List<Pregunta> listar() {

        List<Pregunta> preguntas = new ArrayList<>();

        try (Statement st = getConnection().createStatement()) {

            String sql = "SELECI num_preg, enunciado, categoria, nivel, tipo, "
                    + "ruta_foto, ruta_audio, veces_formulada, veces_acertada, fecha_canc";

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                Pregunta pregunta = crearPregunta(rs);

                if (!preguntas.add(pregunta)) {
                    throw new Exception("no se pudo insertar en la coleccion");
                }
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            
        } catch (Exception ex) {
            
            System.out.println(ex.getMessage());
        }

        return preguntas;
    }

    @Override
    public Pregunta recuperarPorId(int id) {

        return null;
    }

    private Pregunta crearPregunta(final ResultSet rs) throws SQLException {

        return new Pregunta(rs.getInt("num_preg"), rs.getString("enunciado"), rs.getString("categoria"), rs.getInt("nivel"),
                rs.getInt("tipo"), rs.getString("ruta_foto"), rs.getString("ruta_audio"), rs.getInt("veces_formulada"), rs.getInt("veces_acertada"),
                rs.getDate("fecha_canc"));

    }

}
