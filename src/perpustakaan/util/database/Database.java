/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import perpustakaan.util.Config;
import perpustakaan.util.Util;
import perpustakaan.util.database.CallableStatement;
import perpustakaan.util.database.PreparedStatement;
import perpustakaan.util.database.ResultSet;

/**
 *
 * @author MojoMacW7
 */
public class Database {
    public static final String url = "jdbc:sqlite:perpus.db";
    static final String username = "client";
    static final String password = "asdfasdf";
    public static Database instance = null;
    
    public Connection conn;
    
    public static Database getInstance(){
        if (instance == null){
            try{
                instance = new Database();
            }catch(SQLException ex){
                Util.handleException(ex);
            }
        }
        return instance;
    }
    
    
    public Database(String url) throws SQLException{
        open(url);
    }
    public Database() throws SQLException{
        open(url);
    }
    
    public static boolean setAutoCommit(boolean autoCommit){
        try{
            getInstance().conn.setAutoCommit(autoCommit);
            return true;
        }catch (SQLException ex){
            Util.handleException(ex);
        }
        return false;
    }
    
    
    public static boolean commit() {
        try{
            getInstance().conn.commit();
            return true;
        }catch (SQLException ex){
            Util.handleException(ex);
            return false;
        }
    }
    
    public boolean open(String url) {
        try {
            Util.log("Connecting...");
            // db parameters
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            instance = this;
            setAutoCommit(false);
            Util.log("Connected");
            Config.init();
            return true;
        } catch (SQLException ex) {
            Util.handleException(ex);
            return false;
        } 
    }
    
    public static PreparedStatement prepareStatement(String sql){
        try{
            Database conn = getInstance();
            return new PreparedStatement(conn, conn.conn.prepareStatement(sql));
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public static CallableStatement prepareCall(String sql){
        try{
            Database conn = getInstance();
            return new CallableStatement(conn, conn.conn.prepareCall(sql));
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    
    public Statement createStatement(){
        try{
            return conn.createStatement();
        }catch(SQLException ex){
            Util.handleException(ex);
        }
        return null;
    }
    
    
    public static boolean execute(String query){
        try{
            return getInstance().conn.createStatement().execute(query);
        }catch(SQLException ex){
            Util.handleException(ex);
        }
        return false;
    }
    
    public static int executeUpdate(String query){
        try{
            return getInstance().conn.createStatement().executeUpdate(query);
        }catch(SQLException ex){
            Util.handleException(ex);
        }
        return -1;
    }
    
    public static boolean close(){
        try {
            if (instance != null){
                if(instance.conn != null) {
                    instance.conn.close();
                }
                instance = null;
                return true;
            }
        } catch (SQLException ex) {
            Util.handleException(ex);
        }
        return false;
    }
}