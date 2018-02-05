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
public class JadwalException extends Exception {

    /**
     * Creates a new instance of <code>JadwalException</code> without detail
     * message.
     */
    public JadwalException() {
    }

    /**
     * Constructs an instance of <code>JadwalException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public JadwalException(String msg) {
        super(msg);
    }
}
