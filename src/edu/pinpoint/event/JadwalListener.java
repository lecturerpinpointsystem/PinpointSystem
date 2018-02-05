/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.event;

import edu.pinpoint.intity.Jadwal;
import edu.pinpoint.model.JadwalModel;

/**
 *
 * @author Jemmy
 */
public interface JadwalListener {

    public void onChange(JadwalModel jadwalModel);

    public void onInsert(Jadwal jadwal);

    public void onUpdate(Jadwal jadwal);

    public void onDeleteJadwal();
    
}
