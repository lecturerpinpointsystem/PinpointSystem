/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.view;

import edu.pinpoint.controller.JadwalController;
import edu.pinpoint.database.DatabasePengajar;
import edu.pinpoint.error.JadwalException;
import edu.pinpoint.event.JadwalListener;
import edu.pinpoint.intity.Jadwal;
import edu.pinpoint.model.JadwalModel;
import edu.pinpoint.model.TableJadwalModel;
import edu.pinpoint.service.JadwalDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jemmy
 */
public class MainMenuSiswa extends javax.swing.JFrame{

    /**
     * Creates new form MainMenuSiswa
     */
    
    private TableJadwalModel tableJadwalModel;
    
    private JadwalModel jadwalModel;

    private JadwalController jadwalController;

    private TambahJadwal tambahJadwal;
    
    DefaultTableModel dm;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private DefaultTableModel defaultTable;
    
    public MainMenuSiswa() throws SQLException {

        initComponents();
        con = DatabasePengajar.getConnection();
        defaultTable = new DefaultTableModel();
        tblDetail.setModel(defaultTable);
        defaultTable.addColumn("ID");
        defaultTable.addColumn("NAMA");
        defaultTable.addColumn("MATAKULIAH");
        defaultTable.addColumn("RUANGAN");
        defaultTable.addColumn("HARI");
        defaultTable.addColumn("WAKTU MULAI");
        defaultTable.addColumn("WAKTU USAI");
        menu2.setVisible(false);
        menu1.setVisible(false);
        txtMenu2.setVisible(false);
        txtMenu1.setVisible(false);

        getData();
        
        
    }
 public void getData() {
      
        defaultTable.getDataVector().removeAllElements();
        defaultTable.fireTableDataChanged();

        try {
           
            Statement stat = (Statement) DatabasePengajar.getConnection().createStatement();

            String query = "SELECT NOMOR, NAMA, MATAKULIAH, RUANGAN, HARI, MULAI, USAI FROM JADWAL WHERE NAMA LIKE '%"+ txtCari.getText() +"%'";
            ResultSet res = stat.executeQuery(query);

           
            while (res.next()) {
                Object[] obj = new Object[7];
                obj[0] = res.getString("NOMOR");
                obj[1] = res.getString("NAMA");
                obj[2] = res.getString("MATAKULIAH");
                obj[3] = res.getString("RUANGAN");
                obj[4] = res.getString("HARI");
                obj[5] = res.getString("MULAI"); 
                obj[6] = res.getString("USAI");
                 
                defaultTable.addRow(obj);
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
 
 public void getData1() {
   
        defaultTable.getDataVector().removeAllElements();
        defaultTable.fireTableDataChanged();

        try {
   
            Statement stat = (Statement) DatabasePengajar.getConnection().createStatement();

            String query = "SELECT NOMOR, NAMA, MATAKULIAH, RUANGAN, HARI, MULAI, USAI FROM JADWAL WHERE NAMA LIKE '%"+ txtCari.getText() +"%'";
            //String query = "SELECT * FROM JADWAL ";
            ResultSet res = stat.executeQuery(query);

         
            while (res.next()) {
                Object[] obj = new Object[7];
                obj[0] = res.getString("NOMOR");
                obj[1] = res.getString("NAMA");
                obj[2] = res.getString("MATAKULIAH");
                obj[3] = res.getString("RUANGAN");
                obj[4] = res.getString("HARI");
                obj[5] = res.getString("MULAI"); 
                obj[6] = res.getString("USAI");
                 
                defaultTable.addRow(obj);
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
 
  private void filter(String query) {

        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel> (defaultTable);
        tblDetail.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
     private static final Logger LOG = Logger.getLogger(DetailMainMenuPengajar.class.getName());

  

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JPanel();
        txtMenu1 = new javax.swing.JLabel();
        menu1 = new javax.swing.JLabel();
        menuSebelum1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLogout1 = new javax.swing.JPanel();
        txtMenu2 = new javax.swing.JLabel();
        menu2 = new javax.swing.JLabel();
        menuSebelum2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(17, 184, 144));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Brush Script MT", 1, 32)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 255, 204));
        jLabel5.setText("Welcome");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 110, -1));

        btnLogout.setBackground(new java.awt.Color(17, 184, 144));
        btnLogout.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(51, 255, 204)));
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        btnLogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu1.setBackground(new java.awt.Color(255, 255, 255));
        txtMenu1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        txtMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMenu1.setText("Login");
        txtMenu1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(17, 184, 144)));
        txtMenu1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                txtMenu1AncestorMoved(evt);
            }
        });
        btnLogout.add(txtMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pinpoint/asset/Menu1.jpg"))); // NOI18N
        menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu1MouseEntered(evt);
            }
        });
        btnLogout.add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuSebelum1.setBackground(new java.awt.Color(255, 255, 255));
        menuSebelum1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        menuSebelum1.setForeground(new java.awt.Color(255, 255, 255));
        menuSebelum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuSebelum1.setText("Login");
        btnLogout.add(menuSebelum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 160, 30));

        jPanel2.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 160, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pinpoint/asset/PinpointLogo1.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 130, 120));

        btnLogout1.setBackground(new java.awt.Color(17, 184, 144));
        btnLogout1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(51, 255, 204)));
        btnLogout1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogout1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogout1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogout1MouseExited(evt);
            }
        });
        btnLogout1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu2.setBackground(new java.awt.Color(255, 255, 255));
        txtMenu2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        txtMenu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMenu2.setText("Logout");
        txtMenu2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(17, 184, 144)));
        txtMenu2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                txtMenu2AncestorMoved(evt);
            }
        });
        btnLogout1.add(txtMenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        menu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pinpoint/asset/Menu1.jpg"))); // NOI18N
        menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu2MouseEntered(evt);
            }
        });
        btnLogout1.add(menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        menuSebelum2.setBackground(new java.awt.Color(255, 255, 255));
        menuSebelum2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        menuSebelum2.setForeground(new java.awt.Color(255, 255, 255));
        menuSebelum2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuSebelum2.setText("Logout");
        btnLogout1.add(menuSebelum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 160, 30));

        jPanel2.add(btnLogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 160, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 560));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 30, 30));

        tblDetail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblDetail);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 670, -1));

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });
        jPanel1.add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 150, -1));

        btnCari.setText("CARI");
        btnCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCariMouseClicked(evt);
            }
        });
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });
        jPanel1.add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCariKeyReleased

    private void btnCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnCariMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        getData1();
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        // TODO add your handling code here:
        menuSebelum1.setVisible(true);
        menu1.setVisible(false);
        txtMenu1.setVisible(false);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        // TODO add your handling code here:
        menuSebelum1.setVisible(false);
        menu1.setVisible(true);
        txtMenu1.setVisible(true);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void menu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_menu1MouseEntered

    private void txtMenu1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtMenu1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMenu1AncestorMoved

    private void txtMenu2AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtMenu2AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMenu2AncestorMoved

    private void menu2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_menu2MouseEntered

    private void btnLogout1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout1MouseClicked
        // TODO add your handling code here:
        Login login = new Login();
        this.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_btnLogout1MouseClicked

    private void btnLogout1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout1MouseEntered
        // TODO add your handling code here:
        menuSebelum2.setVisible(false);
        menu2.setVisible(true);
        txtMenu2.setVisible(true);
    }//GEN-LAST:event_btnLogout1MouseEntered

    private void btnLogout1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogout1MouseExited
        // TODO add your handling code here:
        menuSebelum2.setVisible(true);
        menu2.setVisible(false);
        txtMenu2.setVisible(false);
    }//GEN-LAST:event_btnLogout1MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenuSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuSiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainMenuSiswa().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DetailMainMenuPengajar.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JPanel btnLogout;
    private javax.swing.JPanel btnLogout1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel menu1;
    private javax.swing.JLabel menu2;
    private javax.swing.JLabel menuSebelum1;
    private javax.swing.JLabel menuSebelum2;
    private javax.swing.JTable tblDetail;
    private javax.swing.JTextField txtCari;
    private javax.swing.JLabel txtMenu1;
    private javax.swing.JLabel txtMenu2;
    // End of variables declaration//GEN-END:variables
 
   

   
    

}