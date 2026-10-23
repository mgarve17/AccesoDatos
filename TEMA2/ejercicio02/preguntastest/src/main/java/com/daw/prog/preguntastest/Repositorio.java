/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.daw.prog.preguntastest;

import java.util.List;

/**
 *
 * @author daw2@iesmhp.local
 * @param <T>
 */
public interface Repositorio <T>{
    
   public List<T> listar();
    public T recuperarPorId(int id);
//    public boolean guardar(T t);
//    public boolean eliminar(int id);
//    public boolean actualizar(T t);
}
