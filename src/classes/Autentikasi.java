/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import perpustakaan.util.Util;
import perpustakaan.util.database.Database;

/**
 *
 * @author ARION
 */
public class Autentikasi {
    public String username;
    public String password;
    
    public boolean cekUser() throws NoSuchAlgorithmException{
        try{
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(password.getBytes(),0,password.length());
            String encPass = new BigInteger(1,digest.digest()).toString(32);
            String sandi = encPass.toUpperCase();
            System.out.println(sandi);
            PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT user WHERE username = ? && password = ?"
            );

            pstmt.setString(1, username);
            pstmt.setString(2, sandi);
            return pstmt.execute();
            
        }catch(SQLException ex){
            Util.handleException (ex);
            return false;
        }
    }
    
    
}
