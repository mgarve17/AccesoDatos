/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ejercicio1;

import java.util.List;

/**
 *
 * @author daw2
 * @param <T>
 */
public interface Repositorio<T> {
    
    public List<T> listar();
    public T porId(int id);
    public boolean guardar(T t);
    public boolean eliminar(int id);
    public boolean actualizar(T t);
}
