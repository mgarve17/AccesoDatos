/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw2
 */
public class PeliculaDAO implements Repositorio<Pelicula> {

    private Connection getConnection() {

        return Conexion.getInstance().getConn();
    }

    @Override
    public List<Pelicula> listar() {
        List<Pelicula> peliculas = new ArrayList<>();

        try (Statement stmt = getConnection().createStatement(); 
                ResultSet rs = stmt.executeQuery("SELECT id, title, director, release_year, genre from movies")) {

            while (rs.next()) {

                Pelicula pelicula = crearPelicula(rs);

                if (!peliculas.add(pelicula)) {
                    throw new Exception("no se ha podido insertar la pelicula en la colección");
                }

            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {

        }

        return peliculas;
    }

    @Override
    public boolean guardar(Pelicula t) {

        
        if (t.getId() > 0) {
            
           String sql = "INSERT INTO movies (title, director, release_year,genre) VALUES(?,?,?,?)"; 
           
           try(PreparedStatement ps = getConnection().prepareCall(sql)){
           
               
           } catch (SQLException ex) {
                System.getLogger(PeliculaDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {

    }

    @Override
    public Pelicula porId(int id) {

    }

    @Override
    public boolean actualizar(Pelicula t) {

    }

    private Pelicula crearPelicula(final ResultSet rs) throws SQLException {

        return new Pelicula(rs.getInt("id"), rs.getString("title"), rs.getString("director"), rs.getDate("release_year"), rs.getString("genre"));
    }

}
