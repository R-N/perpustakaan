/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import perpustakaan.util.Util;
import perpustakaan.util.database.Database;

/**
 *
 * @author LENOVO
 */
public class LoginManager {
    
    public static String username = null;
    
    public static final String SALT = "areng";
    
    public static String hashPassword(String pass){
        return Util.md5(pass + SALT);
    }
    
    public static boolean hasAccount() throws SQLException{
        try{
            ResultSet rs = Database.executeQuery("SELECT COUNT(*) FROM `User`");
            int count = 0;
            if(rs == null){
                throw new RuntimeException("RS NULL");
            }
            if(rs.next()){
                count = rs.getInt(1);
            }
            return count > 0;
        }catch(SQLException ex){
            throw ex;
        }
    }
    
    public static boolean login(String username, String password) throws SQLException{
        password = hashPassword(password);
        try{
            PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT username FROM `User` WHERE username=? AND password=?"
            );
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if(rs == null){
                throw new RuntimeException("RS NULL");
            }
            if(rs.next()){
                LoginManager.username = rs.getString(1);
                return true;
            }
        }catch(SQLException ex){
            throw ex;
        }
        return false;
    }
    
    public static boolean register(String username, String password) throws SQLException{
        password = hashPassword(password);
        try{
            PreparedStatement pstmt = Database.prepareStatement(
                    "INSERT INTO `User`(username, password) VALUES (?, ?)"
            );
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            int result = pstmt.executeUpdate();
            if(result > 0){
                LoginManager.username = username;
                return true;
            }
        }catch(SQLException ex){
            throw ex;
        }
        return false;
    }
}
