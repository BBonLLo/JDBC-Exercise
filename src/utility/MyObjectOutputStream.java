/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author 2dam
 */
public class MyObjectOutputStream extends ObjectOutputStream {
    // The method that creates the header is overwritten.
    protected void writeStreamHeader() throws IOException {
        reset();
    }

    // Constructors.
    public MyObjectOutputStream() throws IOException {
        super();
    }
    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
}
