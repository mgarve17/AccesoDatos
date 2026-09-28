/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.h5_ciudades;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author daw2
 */
public class SinCabecera extends ObjectOutputStream{
    
    public SinCabecera(OutputStream out) throws IOException{
    
        super(out);
    }
    
    public SinCabecera() throws IOException{
    
        super();
    }
    
    @Override
    protected void writeStreamHeader() throws IOException {
    
        reset();
    }
    
    
}
