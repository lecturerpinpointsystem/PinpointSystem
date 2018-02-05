/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.service;

import edu.pinpoint.error.JadwalException;
import edu.pinpoint.intity.Jadwal;
import java.util.List;

/**
 *
 * @author Jemmy
 */
public interface JadwalDao {
    
    public void insertJadwal(Jadwal jadwal) throws JadwalException;
    
    public void updateJadwal(Jadwal jadwal) throws JadwalException;
    
    public void deleteJadwal(String nip) throws JadwalException;
    
    public Jadwal getJadwalNama (String nama) throws JadwalException;
    
    public Jadwal getJadwalNip(String nip) throws JadwalException;
   
    public Jadwal getJadwal(String matakuliah) throws JadwalException;
    
    public List<Jadwal> selectAllJadwal() throws JadwalException;

    public void deleteJadwal(int number);
}
