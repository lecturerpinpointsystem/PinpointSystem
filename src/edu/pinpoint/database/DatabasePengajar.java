/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pinpoint.database;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.pinpoint.implement.JadwalDaoImpl;
import edu.pinpoint.implement.PengajarDaoImpl;
import edu.pinpoint.service.JadwalDao;
import edu.pinpoint.service.PengajarDao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Jemmy
 */
public class DatabasePengajar {
    
    private static Connection connection;
    private static PengajarDao pengajarDao;
    private static JadwalDao jadwalDao;
    
    public static Connection getConnection() throws  SQLException{
     if (connection==null){
         
         MysqlDataSource datasource = new MysqlDataSource();
         
     datasource.setURL("jdbc:mysql://localhost:3306/pinpoint");
     datasource.setUser("root");
     datasource.setPassword("");
     connection= datasource.getConnection();
    
     }

     
     return connection;
    }
    
    public static PengajarDao getPengajarDao() throws SQLException{
        if (pengajarDao==null) {
            pengajarDao = new PengajarDaoImpl(getConnection());
            
        }
        return pengajarDao;
    }
    
    public static JadwalDao getJadwalDao() throws SQLException{
        if (jadwalDao==null) {
            jadwalDao = new JadwalDaoImpl (getConnection());
        }
        
        return jadwalDao;
    }
   
    
}
