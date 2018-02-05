/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.error;

/**
 *
 * @author Jemmy
 */
public class PengajarException extends Exception {

    /**
     * Creates a new instance of <code>PengajarException</code> without detail
     * message.
     */
    public PengajarException() {
    }

    /**
     * Constructs an instance of <code>PengajarException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PengajarException(String msg) {
        super(msg);
    }
}
