/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.implement;


import edu.pinpoint.error.PengajarException;
import edu.pinpoint.intity.Pengajar;
import edu.pinpoint.service.PengajarDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jemmy
 */
public class PengajarDaoImpl implements PengajarDao{
    
    private Connection connection;
    
    private final String insertPengajar = "INSERT INTO DATAPENGAJAR (NIP,NAMA, EMAIL, USERNAME, PASSWORD, ALAMAT) VALUES (?,?,?,?,?,?)";
        
    private final String getByNip = "SELECT * FROM DATAPENGAJAR NIP=?";
    
    private final String getByNama = "SELECT * FROM DATAPENGAJAR NAMA =?";
        
    private final String selectAll = "SELECT * FROM DATAPENGAJAR";
    
    
    
    public PengajarDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
    

    @Override
    public void insertPengajar(Pengajar pengajar) throws PengajarException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPengajar);
            statement.setString(1, pengajar.getNip());
            statement.setString(2, pengajar.getNama());
            statement.setString(3, pengajar.getEmail());
            statement.setString(4, pengajar.getUsername());
            statement.setString(5, pengajar.getPassword());
            statement.setString(6, pengajar.getAlamat());

           
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();

            } catch (SQLException ex) {

            }
            throw new PengajarException(e.getMessage());
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

    @Override
    public void updatePengajar(Pengajar pengajar) throws PengajarException {
    PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement.setString(1, pengajar.getNip());
            statement.setString(1, pengajar.getNama());
            statement.setString(2, pengajar.getEmail());
            statement.setString(3, pengajar.getUsername());
            statement.setString(4, pengajar.getPassword());
            statement.setString(5, pengajar.getAlamat());
            statement.executeUpdate();     
            connection.commit();
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            
            
            throw new PengajarException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (Exception e) {
            }
            
            
            if (statement != null){
                
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }


    }

    
    
}
