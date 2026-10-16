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
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw2
 */
public class PeliculaDAO implements Repositorio<Pelicula> {

    private Connection getConnection() throws SQLException {

        return AccesoBD.getConnection();
        
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
            System.out.println("No se pudo listar " + ex.getMessage());
        }

        return peliculas;
    }

    @Override
    public boolean guardar(Pelicula pelicula) {

        String sql = "insert into movies (title, director, release_year, genre) "
                + "values(?,?,?,?)";
        boolean valido = false;

        try (PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            rellenarParametos(ps, pelicula);
            int resultado = ps.executeUpdate();

            if (resultado == 1) {
                valido = true;
            } else {

                throw new SQLException("No se pudo insertar la pelicula");
            }

            try (ResultSet claves = ps.getGeneratedKeys()) {

                if (claves.next()) {

                    pelicula.setId(claves.getInt(1));
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return valido;

    }

  
    @Override
    public boolean eliminar(int id) {

        boolean valido = false;
        String sql = "delete from movies where id = ?";

        try (PreparedStatement ps = getConnection().prepareCall(sql)) {

            ps.setInt(1, id);

            int salida = ps.executeUpdate();

            if (salida == 1) {
                valido = true;
            } else {

                throw new Exception("No se ha borrado el registro");
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.getLogger(PeliculaDAO.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        return valido;

    }

    @Override
    public Pelicula recuperarPorId(int id) {

        String sql="select title, director, release_year,genre from movies where id = ?";
        
        try(PreparedStatement ps = getConnection().prepareCall(sql)){
        
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()){
            
                return rs.next() ? crearPelicula(rs) : null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("No se pudo buscar por id: " + id);
        }

    }
    
    //        Pelicula pelicula = null;
//
//        String sql = "select title, director, release_year,genre from movies where id = ?";
//        try (PreparedStatement ps = getConnection().prepareCall(sql)) {
//
//            ps.setInt(1, id);
//
//            try (ResultSet rs = ps.executeQuery()) {
//                //si encuentra la pelicula crea el objeto
//                if (rs.next()) {
//                    pelicula = crearPelicula(rs);
//                } else {
//
//                    throw new Exception("No se encontró la pelicula");
//                }
//            } catch (Exception ex) {
//                System.out.println(ex.getMessage());
//            }
//
//        } catch (SQLException ex) {
//
//            System.out.println("SQLException: " + ex.getMessage());
//        }
//
//        return pelicula;

    @Override
    public boolean actualizar(Pelicula pelicula) {

        boolean valido = false;
        String sql = "Update movies set title = ?, director = ?, release_year = ?, genre = ? where id = ?";
        
        try(PreparedStatement ps = getConnection().prepareCall(sql)){
        
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setInt(3, (int) pelicula.getFechaSalida());
            ps.setString(4, pelicula.getGenero());
            ps.setInt(4, pelicula.getId());
            
            int resultado = ps.executeUpdate();
            
            if (resultado == 1) {
                valido = true;
            } else {
            
                throw new SQLException("No se pudo actualizar el registro");
            }
            
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        
        
        return valido;

    }

    private Pelicula crearPelicula(final ResultSet rs) throws SQLException {

        return new Pelicula(rs.getInt("id"), rs.getString("title"), rs.getString("director"), rs.getInt("release_year"), rs.getString("genre"));
    }

    private void rellenarParametos(PreparedStatement ps, Pelicula p) throws SQLException {

        ps.setString(1, p.getTitulo());
        ps.setString(2, p.getDirector());
        if (p.getFechaSalida() != null) {
            ps.setInt(3, p.getFechaSalida());
        } else {

            ps.setNull(3, Types.INTEGER);
        }

        ps.setString(4, p.getGenero());
    }

}
