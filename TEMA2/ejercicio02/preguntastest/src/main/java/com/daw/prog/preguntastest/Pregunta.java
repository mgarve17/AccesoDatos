/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daw.prog.preguntastest;

import java.sql.Date;

/**
 *
 * @author daw2@iesmhp.local
 */
public class Pregunta {
    
    private Integer id;
    private String enunciado;
    private String categoria;
    private Integer nivel;
    private Integer tipo;
    private String rutaFoto;
    private String rutaAudio;
    private Integer vecesFormulada;
    private Integer vecesAcertada;
    private Date fechaCancelada;

    public Pregunta(){}

    public Pregunta(Integer id, String enunciado, String categoria, Integer nivel, Integer tipo, String rutaFoto, String rutaAudio, Integer vecesFormulada, Integer vecesAcertada, Date fechaCancelada) {
        this.id = id;
        this.enunciado = enunciado;
        this.categoria = categoria;
        this.nivel = nivel;
        this.tipo = tipo;
        this.rutaFoto = rutaFoto;
        this.rutaAudio = rutaAudio;
        this.vecesFormulada = vecesFormulada;
        this.vecesAcertada = vecesAcertada;
        this.fechaCancelada = fechaCancelada;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public String getRutaAudio() {
        return rutaAudio;
    }

    public void setRutaAudio(String rutaAudio) {
        this.rutaAudio = rutaAudio;
    }

    public Integer getVecesFormulada() {
        return vecesFormulada;
    }

    public void setVecesFormulada(Integer vecesFormulada) {
        this.vecesFormulada = vecesFormulada;
    }

    public Integer getVecesAcertada() {
        return vecesAcertada;
    }

    public void setVecesAcertada(Integer vecesAcertada) {
        this.vecesAcertada = vecesAcertada;
    }

    public Date getFechaCancelada() {
        return fechaCancelada;
    }

    public void setFechaCancelada(Date fechaCancelada) {
        this.fechaCancelada = fechaCancelada;
    }

    @Override
    public String toString() {
        return "Pregunta{" + "id=" + id + ", enunciado=" + enunciado + ", categoria=" + categoria + ", nivel=" + nivel + ", tipo=" + tipo + ", rutaFoto=" + rutaFoto + ", rutaAudio=" + rutaAudio + ", vecesFormulada=" + vecesFormulada + ", vecesAcertada=" + vecesAcertada + ", fechaCancelada=" + fechaCancelada + '}';
    }
    
    



    
    

    
    
    
    
}
