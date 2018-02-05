/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.intity;

import java.util.Objects;

/**
 *
 * @author Jemmy
 */
public class Jadwal {
    
    private Integer no;
    private String nip;
    private String nama;
    private String matakuliah;
    private String ruangan;
    private String hari;
    private String mulai;
    private String usai;

    public Jadwal() {}
    
    public Jadwal(String nip, String nama, String matakuliah, String ruangan, String hari, String mulai, String usai) {
        this.nip = nip;
        this.nama = nama;
        this.matakuliah = matakuliah;
        this.ruangan = ruangan;
        this.hari = hari;
        this.mulai = mulai;
        this.usai = usai;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.no);
        hash = 23 * hash + Objects.hashCode(this.nip);
        hash = 23 * hash + Objects.hashCode(this.nama);
        hash = 23 * hash + Objects.hashCode(this.matakuliah);
        hash = 23 * hash + Objects.hashCode(this.ruangan);
        hash = 23 * hash + Objects.hashCode(this.hari);
        hash = 23 * hash + Objects.hashCode(this.mulai);
        hash = 23 * hash + Objects.hashCode(this.usai);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jadwal other = (Jadwal) obj;
        if (!Objects.equals(this.nip, other.nip)) {
            return false;
        }
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.matakuliah, other.matakuliah)) {
            return false;
        }
        if (!Objects.equals(this.ruangan, other.ruangan)) {
            return false;
        }
        if (!Objects.equals(this.hari, other.hari)) {
            return false;
        }
        if (!Objects.equals(this.mulai, other.mulai)) {
            return false;
        }
        if (!Objects.equals(this.usai, other.usai)) {
            return false;
        }
        if (!Objects.equals(this.no, other.no)) {
            return false;
        }
        return true;
    }

    
   
    
    
}
