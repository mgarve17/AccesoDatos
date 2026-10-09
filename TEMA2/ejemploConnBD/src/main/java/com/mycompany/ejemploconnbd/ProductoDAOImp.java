/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemploconnbd;

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
public class ProductoDAOImp implements Repositorio<Producto> {

    private Connection getConnection() {
        return AccesoBD.getInstance().getConn();
    }
// recuperamos todos los registros de la bd

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement(); ResultSet rs
                = stmt.executeQuery("SELECT id,nombre,cantidad FROM productos");) {
            while (rs.next()) {
                Producto producto = crearProducto(rs);
                if (!productos.add(producto)) {
                    throw new Exception("error no se ha insertado el objeto en la colección");
                }
            }
        } catch (SQLException ex) {
// errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return productos;
    }
// recuperamos objeto por clave primaria

    @Override
    public Producto porId(int id) {
        Producto producto = null;
        String sql = "SELECT id,nombre,cantidad FROM productos WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    producto = crearProducto(rs);

                }
            }
        } catch (SQLException ex) {
// errores
            System.out.println("SQLException: " + ex.getMessage());
        }
        return producto;
    }
// implementa tanto insertar como modificar
// distinguimos que es una inserción porque el id en la tabla se genera
    //automáticamente

    @Override
    public void guardar(Producto producto) {
        String sql = null;
        if (producto.getId() > 0) {
            sql = "UPDATE productos SET nombre=?,cantidad=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos(nombre,cantidad) VALUES (?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            if (producto.getId() > 0) {
                stmt.setInt(3, producto.getId());
            }
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getCantidad());
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha insertado/modificado un soloregistro");
            }
        } catch (SQLException ex) {
            // errores
            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    // borrar en la base de datos por clave primaria

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id=?";
        try (PreparedStatement stmt = getConnection().prepareStatement(sql);) {
            stmt.setInt(1, id);
            int salida = stmt.executeUpdate();
            if (salida != 1) {
                throw new Exception(" No se ha borrado un solo registro");
            }
        } catch (SQLException ex) {
            // errores

            System.out.println("SQLException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    // método privado crea el objeto producto en este caso utiliza constructor por
    //parámetros.

    private Producto crearProducto(final ResultSet rs) throws SQLException {
        return new Producto(
                rs.getInt("id"), rs.getString("nombre"), rs.getInt("cantidad"));
    }

}
