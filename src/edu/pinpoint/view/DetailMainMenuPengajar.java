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
import edu.pinpoint.implement.JadwalDaoImpl;
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
public class DetailMainMenuPengajar extends javax.swing.JFrame{ //implements JadwalListener, ListSelectionListener{

    /**
     * Creates new form DetailMainMenuPengajar
     */
    
    private TableJadwalModel tableJadwalModel;
    
    private JadwalModel jadwalModel;

    private JadwalController jadwalController;

    private TambahJadwal tambahJadwal;
    
    private DetailMainMenuPengajar detailPengajar;
    
    
    DefaultTableModel dm;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private DefaultTableModel defaultTable;
    
    
    public DetailMainMenuPengajar() throws SQLException {
        /*tableJadwalModel = new TableJadwalModel();
      
      
        jadwalModel = new JadwalModel();
        jadwalModel.setJadwalListener(this);
        
        jadwalController = new JadwalController();
        jadwalController.setJadwalModel(jadwalModel);
        
        initComponents();
        
        
        tblDetail.getSelectionModel().addListSelectionListener(this);
        tblDetail.setModel(tableJadwalModel);*/
        
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
        

        getData();
        
        menu.setVisible(false);
        menu1.setVisible(false);
        menu2.setVisible(false);
        txtMenu.setVisible(false);
        txtMenu1.setVisible(false);
        txtMenu2.setVisible(false);
       }

    
      public void getData() {
   
        defaultTable.getDataVector().removeAllElements();
        defaultTable.fireTableDataChanged();

        try {
   
            Statement stat = (Statement) DatabasePengajar.getConnection().createStatement();

            //String query = "SELECT JADWAL.NOMOR, DATAPENGAJAR.NAMA, JADWAL.MATAKULIAH,RUANGAN,HARI,MULAI,USAI FROM DATAPENGAJAR INNER JOIN JADWAL ON DATAPENGAJAR.NIP=JADWAL.NIP;";
            String query = "SELECT NOMOR, NAMA, MATAKULIAH, RUANGAN, HARI, MULAI, USAI FROM JADWAL";
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

    public JTable getTblDetail() {
        return tblDetail;
    }

    public void setTblDetail(JTable tblDetail) {
        this.tblDetail = tblDetail;
    }

   
    
    
    

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
        btnTambah = new javax.swing.JPanel();
        txtMenu = new javax.swing.JLabel();
        menuSebelum = new javax.swing.JLabel();
        menu = new javax.swing.JLabel();
        btnHapus = new javax.swing.JPanel();
        txtMenu1 = new javax.swing.JLabel();
        menuSebelum1 = new javax.swing.JLabel();
        menu1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JPanel();
        txtMenu2 = new javax.swing.JLabel();
        menuSebelum2 = new javax.swing.JLabel();
        menu2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 255, 204));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(17, 184, 144));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Brush Script MT", 1, 32)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 255, 204));
        jLabel5.setText("Welcome");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 110, -1));

        btnTambah.setBackground(new java.awt.Color(17, 184, 144));
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTambahMouseExited(evt);
            }
        });
        btnTambah.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu.setBackground(new java.awt.Color(255, 255, 255));
        txtMenu.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        txtMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMenu.setText("Add Schedule");
        txtMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(17, 184, 144)));
        txtMenu.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                txtMenuAncestorMoved(evt);
            }
        });
        btnTambah.add(txtMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        menuSebelum.setBackground(new java.awt.Color(255, 255, 255));
        menuSebelum.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        menuSebelum.setForeground(new java.awt.Color(255, 255, 255));
        menuSebelum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuSebelum.setText("Add Schedule");
        menuSebelum.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(51, 255, 204)));
        menuSebelum.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                menuSebelumAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        btnTambah.add(menuSebelum, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pinpoint/asset/Menu1.jpg"))); // NOI18N
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuMouseEntered(evt);
            }
        });
        btnTambah.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jPanel2.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 160, 30));

        btnHapus.setBackground(new java.awt.Color(17, 184, 144));
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHapusMouseExited(evt);
            }
        });
        btnHapus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMenu1.setBackground(new java.awt.Color(255, 255, 255));
        txtMenu1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        txtMenu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMenu1.setText("Delete Schedule");
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
        btnHapus.add(txtMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        menuSebelum1.setBackground(new java.awt.Color(255, 255, 255));
        menuSebelum1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        menuSebelum1.setForeground(new java.awt.Color(255, 255, 255));
        menuSebelum1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuSebelum1.setText("Delete Schedule");
        menuSebelum1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(51, 255, 204)));
        btnHapus.add(menuSebelum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 160, 30));

        menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pinpoint/asset/Menu1.jpg"))); // NOI18N
        menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu1MouseEntered(evt);
            }
        });
        btnHapus.add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 160, -1));

        btnLogout.setBackground(new java.awt.Color(17, 184, 144));
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
        btnLogout.add(txtMenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        menuSebelum2.setBackground(new java.awt.Color(255, 255, 255));
        menuSebelum2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        menuSebelum2.setForeground(new java.awt.Color(255, 255, 255));
        menuSebelum2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuSebelum2.setText("Logout");
        menuSebelum2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(51, 255, 204)));
        btnLogout.add(menuSebelum2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 160, 30));

        menu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pinpoint/asset/Menu1.jpg"))); // NOI18N
        menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menu2MouseEntered(evt);
            }
        });
        btnLogout.add(menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 160, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/pinpoint/asset/PinpointLogo1.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 130, 120));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
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

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        TambahJadwal tambahJadwal = new TambahJadwal();
        tambahJadwal.setVisible(true);
        /*TambahJadwal tambahJadwal = null;
        try {
            tambahJadwal = new TambahJadwal();
        } catch (SQLException ex) {
            Logger.getLogger(DetailMainMenuPengajar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JadwalException ex) {
            Logger.getLogger(DetailMainMenuPengajar.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       
        
        
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked

        
            // TODO add your handling code here:
            int row = tblDetail.getSelectedRow();
            if (row >= 0) {
            int ok = JOptionPane.showConfirmDialog(null, "Apakah Yakin Menghapus Record Ini???", "Confirmation", JOptionPane.YES_NO_OPTION);
            int baris = tblDetail.getSelectedRow();
            int kolom = tblDetail.getSelectedColumn();
            String dataTerpilih = tblDetail.getValueAt(baris, kolom).toString();
            PreparedStatement st = null;
            if (ok == 0) {

                try {
                    JadwalDao jadwalDao= DatabasePengajar.getJadwalDao();
                    String kolom1 = tblDetail.getValueAt(baris, 0).toString();
                    int nilai=Integer.valueOf(kolom1);
                
                    jadwalDao.deleteJadwal(nilai);
                   
                    st.executeUpdate();
                      DefaultTableModel model = (DefaultTableModel) tblDetail.getModel();
                      model.removeRow(row);
            
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Delete sukses");
                      DefaultTableModel model = (DefaultTableModel) tblDetail.getModel();
                      model.removeRow(row);
                    
                }
            
            }
            
        }
        
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        getData1();
        
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariKeyReleased

    private void btnCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseClicked
       
    }//GEN-LAST:event_btnCariMouseClicked

    private void menuSebelumAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_menuSebelumAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_menuSebelumAncestorMoved

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jPanel1MouseEntered

    private void menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_menuMouseEntered

    private void txtMenuAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtMenuAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMenuAncestorMoved

    private void btnTambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseEntered
        // TODO add your handling code here:
         menuSebelum.setVisible(false);
        menu.setVisible(true);
        txtMenu.setVisible(true);
    }//GEN-LAST:event_btnTambahMouseEntered

    private void btnTambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseExited
        // TODO add your handling code here:
         menuSebelum.setVisible(true);
        menu.setVisible(false);
        txtMenu.setVisible(false);
    }//GEN-LAST:event_btnTambahMouseExited

    private void menu1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_menu1MouseEntered

    private void txtMenu1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtMenu1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMenu1AncestorMoved

    private void btnHapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseEntered
        // TODO add your handling code here:
         menuSebelum1.setVisible(false);
        menu1.setVisible(true);
        txtMenu1.setVisible(true);
    }//GEN-LAST:event_btnHapusMouseEntered

    private void btnHapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseExited
        // TODO add your handling code here:
         menuSebelum1.setVisible(true);
         menu1.setVisible(false);
        txtMenu1.setVisible(false);
    }//GEN-LAST:event_btnHapusMouseExited

    private void menu2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_menu2MouseEntered

    private void txtMenu2AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtMenu2AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMenu2AncestorMoved

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        // TODO add your handling code here:
        menuSebelum2.setVisible(false);
        menu2.setVisible(true);
        txtMenu2.setVisible(true);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        // TODO add your handling code here:
         menuSebelum2.setVisible(true);
        menu2.setVisible(false);
        txtMenu2.setVisible(false);
    }//GEN-LAST:event_btnLogoutMouseExited

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
            java.util.logging.Logger.getLogger(DetailMainMenuPengajar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetailMainMenuPengajar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetailMainMenuPengajar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetailMainMenuPengajar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DetailMainMenuPengajar().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DetailMainMenuPengajar.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JPanel btnHapus;
    private javax.swing.JPanel btnLogout;
    private javax.swing.JPanel btnTambah;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel menu;
    private javax.swing.JLabel menu1;
    private javax.swing.JLabel menu2;
    private javax.swing.JLabel menuSebelum;
    private javax.swing.JLabel menuSebelum1;
    private javax.swing.JLabel menuSebelum2;
    private javax.swing.JTable tblDetail;
    private javax.swing.JTextField txtCari;
    private javax.swing.JLabel txtMenu;
    private javax.swing.JLabel txtMenu1;
    private javax.swing.JLabel txtMenu2;
    // End of variables declaration//GEN-END:variables

    
    
   
/*
    @Override
    public void onChange(JadwalModel jadwalModel) {
        tambahJadwal.getTxtNip().setText(jadwalModel.getNip());
        tambahJadwal.getTxtNama().setText(jadwalModel.getNama());
        tambahJadwal.getTxtMatakuliah().setText(jadwalModel.getMatakuliah());
        tambahJadwal.getTxtRuang().setText(jadwalModel.getRuangan());
        tambahJadwal.getTxtHari().setText(jadwalModel.getHari());
        tambahJadwal.getTxtMulai().setText(jadwalModel.getMulai());
        tambahJadwal.getTxtUsai().setText(jadwalModel.getUsai());
    }

    @Override
    public void onInsert(Jadwal jadwal) {
       tableJadwalModel.add(jadwal);
    }

    @Override
    public void onUpdate(Jadwal jadwal) {
        int index = tblDetail.getSelectedRow();
        tableJadwalModel.set(index, jadwal);
    }

    @Override
    public void onDeleteJadwal() {
        int index = tblDetail.getSelectedRow();
        tableJadwalModel.remove(index);
    }
    
     @Override
    public void valueChanged(ListSelectionEvent lse) {
        try {
            Jadwal jadwal = tableJadwalModel.get(tblDetail.getSelectedRow());
            tambahJadwal.getTxtNip().setText(jadwal.getNip());
            tambahJadwal.getTxtNama().setText(jadwal.getNama());
            tambahJadwal.getTxtMatakuliah().setText(jadwal.getMatakuliah());
            tambahJadwal.getTxtRuang().setText(jadwal.getRuangan());
            tambahJadwal.getTxtHari().setText(jadwal.getHari());
            tambahJadwal.getTxtMulai().setText(jadwal.getMulai());
            tambahJadwal.getTxtUsai().setText(jadwal.getUsai());
            
            
        } catch (IndexOutOfBoundsException exception) {
        }
        
    }
    
     public void loadDatabase() throws SQLException, JadwalException{
        JadwalDao jadwalDao = DatabasePengajar.getJadwalDao();
        tableJadwalModel.setList(jadwalDao.selectAllJadwal());
}*/
}
