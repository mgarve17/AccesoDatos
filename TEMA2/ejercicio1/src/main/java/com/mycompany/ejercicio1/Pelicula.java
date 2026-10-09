/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author daw2
 */
public class Pelicula {

    private Integer id;//NULL hadta que se inserta (auto_increment)
    private String titulo;
    private String director;
    private Integer fechaSalida;
    private String genero;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, Integer fecha, String genero) {

        this(null, titulo, director, fecha, genero);
    }

    public Pelicula(Integer id, String titulo, String director, Integer fecha, String genero) {

        this.id = id;
        setTitulo(titulo);
        setDirector(director);
        this.fechaSalida = (fecha);
        setGenero(genero);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        
        if (titulo == null || titulo.isBlank()) {
            
            throw new IllegalArgumentException("el titulo es obligatorio");
        }
        
        if (titulo.length() > 150) {
            throw new IllegalArgumentException("el titulo es superior a 150 caracteres");
        }
        
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        
        if (director == null && director.length() > 100) {
            throw new IllegalArgumentException("el director es superior a 100 caracteres");
        }
        
        this.director = director;
    }

    public Integer getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Integer fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        
        if (genero == null && genero.length() > 50) {
            
            throw new IllegalArgumentException("el genero es superior a 50 caracteres");
        }
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", director=" + director + ", fechaSalida=" + fechaSalida + ", genero=" + genero + '}';
    }

}
