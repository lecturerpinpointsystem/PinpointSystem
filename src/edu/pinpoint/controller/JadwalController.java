/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.controller;

import edu.pinpoint.model.JadwalModel;
import edu.pinpoint.view.DetailMainMenuPengajar;
import edu.pinpoint.view.TambahJadwal;
import javax.swing.JOptionPane;

/**
 *
 * @author Jemmy
 */
public class JadwalController {
    
    private JadwalModel jadwalModel;

    public void setJadwalModel(JadwalModel jadwalModel) {
        this.jadwalModel = jadwalModel;
    }
    
    public void resetJadwal (TambahJadwal tambahJadwal){
        jadwalModel.resetJadwal();
    }
    
    public void insertJadwal (TambahJadwal tambahJadwal){
        String nip = tambahJadwal.getTxtNip().getText();
        String nama = tambahJadwal.getTxtNama().getText();
        String matakuliah = tambahJadwal.getTxtMatakuliah().getText();
        String ruangan = tambahJadwal.getTxtRuang().getText();
        String hari = tambahJadwal.getTxtHari().getText();
        String mulai = tambahJadwal.getTxtMulai().getText();
        String usai = tambahJadwal.getTxtUsai().getText();
        
        if (nip.trim().equals("") || nama.trim().equals("") || matakuliah.trim().equals("") || ruangan.trim().equals("") || hari.trim().equals("") || mulai.trim().equals("") || usai.trim().equals("")) {
            JOptionPane.showMessageDialog(tambahJadwal,"Form Tidak Boleh Ada Yang Kosong");
        }else if (nip.length() > 12){
            JOptionPane.showMessageDialog(tambahJadwal, "NIP Tidak Boleh Lebih Dari 12 Digit");
        }else if (ruangan.length() > 10) {
            JOptionPane.showMessageDialog(tambahJadwal, "Nomor Ruangan Tidak Boleh Lebih Dari 10 Digit");
        }else if (!mulai.trim().contains(":") || !usai.trim().contains(":")) {
            JOptionPane.showMessageDialog(tambahJadwal, "Tolong Tulis Sesuai Contoh Yang Tersedia \n \n Contoh = 12:30 ");
        }else{
            
            jadwalModel.setNip(nip);
            jadwalModel.setNama(nama);
            jadwalModel.setMatakuliah(matakuliah);
            jadwalModel.setRuangan(ruangan);
            jadwalModel.setHari(hari);
            jadwalModel.setMulai(mulai);
            jadwalModel.setUsai(usai);
            
            try {
                jadwalModel.insertJadwal();
                JOptionPane.showMessageDialog(tambahJadwal, "Data Berhasil Ditambahkan");
                jadwalModel.resetJadwal();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(tambahJadwal, new Object[]{"[Error] Euy mang ", throwable.getMessage()});
                
            }
            
        }
    }
    
     
     public void deleteJadwal(DetailMainMenuPengajar detailPengajar){
        
        if (detailPengajar.getTblDetail().getSelectedRowCount()==0) {
            JOptionPane.showMessageDialog(detailPengajar,"Pilih data terlebih dahulu");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(detailPengajar, "Anda yakin ingin menghapus data ?")==JOptionPane.OK_OPTION) {
               
                
            
            try {
                jadwalModel.deleteJadwal();
                JOptionPane.showMessageDialog(detailPengajar, "Data berhasil dihapus");
                jadwalModel.resetJadwal();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(detailPengajar, new Object[]{"[Error] ", throwable.getMessage()});
            }
        }


}
}
    

    

