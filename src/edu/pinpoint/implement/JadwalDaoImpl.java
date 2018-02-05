/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.implement;

import edu.pinpoint.error.JadwalException;
import edu.pinpoint.intity.Jadwal;
import edu.pinpoint.service.JadwalDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jemmy
 */
public class JadwalDaoImpl implements JadwalDao{

    private Connection connection;

    public JadwalDaoImpl() {
    }

    public JadwalDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    private final String insertJadwal = "INSERT INTO JADWAL (NIP, NAMA, MATAKULIAH, RUANGAN, HARI, MULAI, USAI) VALUES (?,?,?,?,?,?,?)";
    
    private final String updateJadwal = "UPDATE JADWAL SET NIP=?, NAMA=?, MATAKULIAH=?, RUANGAN=?, HARI=?, MULAI=?, USAI=? WHERE NIP=?";
    
    private final String deleteJadwal = "DELETE FROM JADWAL WHERE NOMOR =?";
    
    private final String getByNip = "SELECT * FROM JADWAL WHERE NIP=?";
    
    private final String getByNama = "SELECT * FROM JADWAL WHERE NAMA LIKE=?";
    
    private final String getByMatakuliah = "SELECT * FROM JADWAL WHERE MATAKULIAH =?";
    
    private final String selectAll = "SELECT * FROM JADWAL";
    
    @Override
    public void insertJadwal(Jadwal jadwal) throws JadwalException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(insertJadwal, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, jadwal.getNip());
            statement.setString(2, jadwal.getNama());
            statement.setString(3, jadwal.getMatakuliah());
            statement.setString(4, jadwal.getRuangan());           
            statement.setString(5, jadwal.getHari());           
            statement.setString(6, jadwal.getMulai());           
            statement.setString(7, jadwal.getUsai());           
            statement.executeUpdate();
            
            connection.commit();
            
        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JadwalException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
            }
            }
            
        }
    }

    @Override
    public void updateJadwal(Jadwal jadwal) throws JadwalException {
         PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            
            statement = connection.prepareStatement(updateJadwal);
            statement.setString(1, jadwal.getNip());
            statement.setString(2, jadwal.getNama());
            statement.setString(3, jadwal.getMatakuliah());
            statement.setString(4, jadwal.getRuangan());           
            statement.setString(5, jadwal.getHari());           
            statement.setString(6, jadwal.getMulai());           
            statement.setString(7, jadwal.getUsai());           
            statement.executeUpdate();
            
            connection.commit();
            
        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JadwalException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
            }
            }
            
        }
    }

    @Override
    public void deleteJadwal(String nip) throws JadwalException {
     PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteJadwal);
            statement.setString(1, nip);
            
            statement.executeUpdate();
            connection.commit();
            
        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JadwalException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
            }
            }
            
        }   
    }

    @Override
    public Jadwal getJadwalNip(String nip) throws JadwalException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByNip);
            statement.setString(1, nip);
            
            ResultSet result = statement.executeQuery();
            Jadwal jadwal = null;
            
            if(result.next()){
                jadwal = new Jadwal();
                jadwal.setNip(result.getString("NIP"));
                jadwal.setNama(result.getString("NAMA"));
                jadwal.setMatakuliah(result.getString("MATAKULIAH"));
                jadwal.setRuangan(result.getString("RUANGAN"));
                jadwal.setHari(result.getString("HARI"));
                jadwal.setMulai(result.getString("MULAI"));
               
            }else{
                throw new JadwalException("Pengajar dengan NIP: "+nip+" Tidak Ditemukan");
            }
            connection.commit();
            return jadwal;
        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JadwalException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
            }
            }
            
        }
    }

    @Override
    public Jadwal getJadwal(String matakuliah) throws JadwalException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByNip);
            statement.setString(1, matakuliah);
            
            ResultSet result = statement.executeQuery();
            Jadwal jadwal = null;
            
            if(result.next()){
                jadwal = new Jadwal();
                jadwal.setNip(result.getString("NIP"));
                jadwal.setNama(result.getString("NAMA"));
                jadwal.setMatakuliah(result.getString("MATAKULIAH"));
                jadwal.setRuangan(result.getString("RUANGAN"));
                jadwal.setHari(result.getString("HARI"));
                jadwal.setMulai(result.getString("MULAI"));
               
            }else{
                throw new JadwalException("Matakuliah : "+matakuliah+" Tidak Ditemukan");
            }
            connection.commit();
            return jadwal;
        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JadwalException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
            }
            }
            
        }
    }

    @Override
    public List<Jadwal> selectAllJadwal() throws JadwalException {
         Statement statement = null;
        List<Jadwal> list = new ArrayList<Jadwal>();
        
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            
            
            ResultSet result = statement.executeQuery(selectAll);
            Jadwal jadwal = null;
            
            while(result.next()){
                jadwal = new Jadwal();
                jadwal.setNip(result.getString("NIP"));
                jadwal.setNama(result.getString("NAMA"));
                jadwal.setMatakuliah(result.getString("MATAKULIAH"));
                jadwal.setRuangan(result.getString("RUANGAN"));
                jadwal.setHari(result.getString("HARI"));
                jadwal.setMulai(result.getString("MULAI"));
                jadwal.setUsai(result.getString("USAI"));
                list.add(jadwal);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JadwalException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
            }
            }
            
        }
    }

    @Override
    public Jadwal getJadwalNama(String nama) throws JadwalException {
        
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByNip);
            statement.setString(1, nama);
            
            ResultSet result = statement.executeQuery();
            Jadwal jadwal = null;
            
            if(result.next()){
                jadwal = new Jadwal();
                jadwal.setNip(result.getString("NIP"));
                jadwal.setNama(result.getString("NAMA"));
                jadwal.setMatakuliah(result.getString("MATAKULIAH"));
                jadwal.setRuangan(result.getString("RUANGAN"));
                jadwal.setHari(result.getString("HARI"));
                jadwal.setMulai(result.getString("MULAI"));
               
            }else{
                throw new JadwalException("Pengajar Dengan Nama "+nama+"Tidak Ditemukan");
            }
            connection.commit();
            return jadwal;
        } catch (SQLException e) {
            
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new JadwalException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
            }
            }
            
        }
    }

    @Override
    public void deleteJadwal(int number) {
       PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteJadwal);
            statement.setInt(1, number);
            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                try {
                    connection.rollback();
                    
                } catch (SQLException ex) {
                    
                }
                throw new JadwalException(e.getMessage());
            } catch (JadwalException ex) {
               Logger.getLogger(JadwalDaoImpl.class.getName()).log(Level.SEVERE, null, ex);

            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {

            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {

                }
            }

        }
    }
    
}
