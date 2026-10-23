/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.repaso_examen;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author M
 */
public class SInCabecera extends ObjectOutputStream{

    public SInCabecera(OutputStream out) throws IOException {
        super(out);
    }

    public SInCabecera() throws IOException {
        super();
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        
        reset();
    }
    
    
    
    
}
