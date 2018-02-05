/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.service;


import edu.pinpoint.error.PengajarException;
import edu.pinpoint.intity.Pengajar;

/**
 *
 * @author Jemmy
 */
public interface PengajarDao {
    public void insertPengajar(Pengajar pengajar) throws PengajarException;

    public void updatePengajar(Pengajar pengajar) throws PengajarException;

}
