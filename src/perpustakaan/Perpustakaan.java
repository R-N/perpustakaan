/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import perpustakaan.util.database.Database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import perpustakaan.util.Util;


/**
 *
 * @author LENOVO
 */
public class Perpustakaan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        try{
            Database db = Database.getInstance();
            java.sql.PreparedStatement pstmt = db.conn.prepareStatement(
                    "INSERT INTO BUKU VALUES(?, 'asdf', 'asdf', 0)"
            );
            pstmt.setString(1, "qew");
            pstmt.executeUpdate();
        }catch(java.sql.SQLException ex){
            ex.printStackTrace();
        }*/
        
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "INSERT INTO BUKU VALUES(?, 'asdf', 'asdf', 0)"
            );
            pstmt.setString(1, "trtr");
            pstmt.executeUpdate();
        }catch(SQLException ex){
            Util.handleException(ex);
        }
    }
    
}
