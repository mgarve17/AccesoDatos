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

/**
 *
 * @author daw2
 */
public class gestorBD {
    // private Connection conn = AccesoBD.getInstance().getConn();

    public static void insertarDatos() {

        Statement sentencia = null;
        Connection conn = AccesoBD.getInstance().getConn();

        try {

            sentencia = conn.createStatement();

            //dentro del executeUpdate se mete la query
            String inserta = "INSERT INTO productos" + "(nombre, cantidad)"
                    + "VALUES ('melocotones', 8)" + "('platanos', 12), ('peras', 3)";

            int result = sentencia.executeUpdate(inserta);

            if (result == 3) {
                System.out.println("Filas afectadas: " + result);
            } else {

                throw new Exception("error no se han insertado todos los registros");
            }

        } catch (SQLException e) {

        } catch (Exception ex) {
            System.getLogger(gestorBD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {

            try {

                if (sentencia != null) {

                    sentencia.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la sentencia" + e.getMessage());
            }
        }

    }
    
    public static void insertarDatos2(){
    
         Connection conn = AccesoBD.getInstance().getConn();
         
         try(Statement sentencia = conn.createStatement()){
         
             String query = "INSERT INTO productos" 
                     + "VALUES ('manzanas' , 18)"
                     + "('kiwis',22),('naranjas',23)";
             
             int result = sentencia.executeUpdate(query);
             
             if (result == 3) {
                 
                 System.out.println("Filas afectadas: " + result);
             } else {
             
                 throw new Exception("error no se han insertado todos los registros");
             }
             
         } catch (SQLException ex) {
            System.getLogger(gestorBD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (Exception ex) {
            System.getLogger(gestorBD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    public static void mostrarDatos(){
    
          Statement sentencia = null;
          ResultSet rs = null;
        Connection conn = AccesoBD.getInstance().getConn();
        
        try {
        
            sentencia = conn.createStatement();
            String sql = "select id, nombre, cantidad from productos";
            
            rs = sentencia.executeQuery(sql);
            while(rs.next()){
            
                System.out.print(rs.getInt(1) + " ");
                System.out.print(rs.getString("nombre") + " ");
                System.out.print(rs.getInt(3));
            }
            
            
            
        }catch(SQLException e){
        
            System.out.println("ERROR de la consulta" + e.getLocalizedMessage());
        } finally{
        
            try{
            
                if (sentencia != null) {
                    rs.close();
                    sentencia.close();
                }
            } catch(SQLException e){
            
                System.out.println("ERROR al cerrar la sentencia" + e.getMessage());
            }
        }
    }
    
    public static void mostrarDatos2(){
    
        //dentro de executeQuery Codigo de la select
        String sql = "select id, nomobre, cantidad from productos";
        Connection conn = AccesoBD.getInstance().getConn();
        
        try(Statement sentencia = conn.createStatement();
                ResultSet rs = sentencia.executeQuery(sql);)
        {
        
            while(rs.next()){
            
                //la columna el tipo en los get, su posicion o nombre
                System.out.print(rs.getInt(1) + " ");
                System.out.print(rs.getString("nombre") + " ");
                System.out.print(rs.getInt(3));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error en la consulta " + ex.getMessage());
        }
        
    }
    
    //SENTENCIAS PREPARADAS
    public static void getProductosCantidad(int cantidad){
    
        PreparedStatement ps = null;
        
        ResultSet rs = null;
        
        Connection conn = AccesoBD.getInstance().getConn();
        String query = "SELECT id, nombre, cantidad from productos where cantidad > ?";
        
        try{
        
            //consulta preparada
            ps = conn.prepareStatement(query);
            //indico que para el primer parámetro el valor parado por parámetro
            ps.setInt(1, cantidad);
            rs = ps.executeQuery();
            
            System.out.println("Productos con cantidad > que : " + cantidad + "\n");
            
            while(rs.next()){
            
                System.out.println(rs.getString("nombre") + "con cantidad: " + rs.getInt(3));
            }
        }catch(SQLException e){
        
            System.out.println("Error en la ejecutcion getProductosCantidad" + e.getMessage());
            
        } finally {
        
            try {
            
                if (ps != null) {
                    rs.close();
                    ps.close();
                }
            }catch(SQLException e){
            
            }
        }
    }
    
    public static void getProductosCantidad2(int cantidad){
    
        String sql = "SELECT id, nombre, cantidad from productos where cantidad > ?";
        Connection conn = AccesoBD.getInstance().getConn();
        
        try(PreparedStatement ps = conn.prepareStatement(sql)){
        
            //consulta preparada
            ps.setInt(1, cantidad);
            
            try(ResultSet rs = ps.executeQuery();){
            
                System.out.println("Productos con cantidad > que : " + cantidad + "\n");
                
                while(rs.next()){
                
                    System.out.println(rs.getString("nombre") + "con cantidad: " + rs.getInt(3));
                }
            }
        
        } catch (SQLException ex) {
            System.getLogger(gestorBD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
    
    public static void insertarProductos2BD(String nombre, int cantidad){
    
        Connection conn = AccesoBD.getInstance().getConn();
        String sql = "INSERT INTO productos (nombre, cantidad) VALUES (?,?)";
        try(PreparedStatement ps = conn.prepareStatement(sql)){
        
            ps.setString(1, nombre);
            ps.setInt(2, cantidad);
            
            int rs = ps.executeUpdate();
            
            if (rs == 1) {
                System.out.println("Ha sido insertado el producto");
            }else{
            
                throw new Exception("Error no se ha realizado la inserción");
            }
            
        } catch (SQLException ex) {
            System.getLogger(gestorBD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (Exception ex) {
            System.getLogger(gestorBD.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
    
    
    
}
