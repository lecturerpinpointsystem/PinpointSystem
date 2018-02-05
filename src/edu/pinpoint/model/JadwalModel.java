/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.model;

import edu.pinpoint.database.DatabasePengajar;
import edu.pinpoint.error.JadwalException;
import edu.pinpoint.event.JadwalListener;
import edu.pinpoint.intity.Jadwal;
import edu.pinpoint.service.JadwalDao;
import java.sql.SQLException;

/**
 *
 * @author Jemmy
 */
public class JadwalModel {
    
    private String nip;
    private String nama;
    private String matakuliah;
    private String ruangan;
    private String hari;
    private String mulai;
    private String usai;
    
    private JadwalListener jadwalListener;
    
    

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMatakuliah() {
        return matakuliah;
    }

    public void setMatakuliah(String matakuliah) {
        this.matakuliah = matakuliah;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getMulai() {
        return mulai;
    }

    public void setMulai(String mulai) {
        this.mulai = mulai;
    }

    public String getUsai() {
        return usai;
    }

    public void setUsai(String usai) {
        this.usai = usai;
    }

    public JadwalListener getJadwalListener() {
        return jadwalListener;
    }

    public void setJadwalListener(JadwalListener jadwalListener) {
        this.jadwalListener = jadwalListener;
    }
    
    protected void fireOnChange(){
        if (jadwalListener != null) {
            jadwalListener.onChange(this);
        }
    }
    
    protected void fireOnInsert(Jadwal jadwal){
        if (jadwalListener != null) {
            jadwalListener.onInsert(jadwal);
        }
    }
    
    protected void fireOnUpdate(Jadwal jadwal){
        if (jadwalListener != null) {
            jadwalListener.onUpdate(jadwal);
        }
    }
    
    protected void fireOnDelete(){
        if (jadwalListener != null) {
            jadwalListener.onDeleteJadwal();
        }
    }
    
    public void insertJadwal() throws SQLException, JadwalException{
    
        JadwalDao jadwalDao = DatabasePengajar.getJadwalDao();
        Jadwal jadwal = new Jadwal();
        jadwal.setNip(nip);
        jadwal.setNama(nama);
        jadwal.setMatakuliah(matakuliah);
        jadwal.setRuangan(ruangan);
        jadwal.setHari(hari);
        jadwal.setMulai(mulai);
        jadwal.setUsai(usai);
        
        jadwalDao.insertJadwal(jadwal);
        fireOnInsert(jadwal);
        
    }
    
    public void updateJadwal() throws SQLException, JadwalException{
        
        JadwalDao jadwalDao = DatabasePengajar.getJadwalDao();
        Jadwal jadwal = new Jadwal();
        jadwal.setNip(nip);
        jadwal.setNama(nama);
        jadwal.setMatakuliah(matakuliah);
        jadwal.setRuangan(ruangan);
        jadwal.setHari(hari);
        jadwal.setMulai(mulai);
        jadwal.setUsai(usai);
        
        
        
        jadwalDao.updateJadwal(jadwal);
        fireOnUpdate(jadwal);
    
    }
    
        public void deleteJadwal() throws SQLException, JadwalException{
        
        JadwalDao jadwalDao = DatabasePengajar.getJadwalDao();
        jadwalDao.deleteJadwal(nip);
        fireOnDelete();    
    }
        
    public void resetJadwal(){
        setNip("");
        setNama("");
        setMatakuliah("");
        setRuangan("");
        setHari("");
        setMulai("");
        setUsai("");
        
        }    

    
}
