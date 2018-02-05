/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.main;

import edu.pinpoint.database.DatabasePengajar;
import edu.pinpoint.error.JadwalException;
import edu.pinpoint.error.PengajarException;
import edu.pinpoint.service.PengajarDao;
import edu.pinpoint.view.DetailMainMenuPengajar;
import edu.pinpoint.view.MainMenuSiswa;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Jemmy
 */
public class Pinpoint {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        DatabasePengajar.getConnection();
        PengajarDao ajar = DatabasePengajar.getPengajarDao();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainMenuSiswa menuSiswa = new MainMenuSiswa();
                    menuSiswa.setVisible(true);
                    
                } catch (SQLException e) {
                }
                
            }
        });
    }
    
}