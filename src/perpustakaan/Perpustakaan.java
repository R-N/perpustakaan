/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;

import classes.Peminjaman;
import java.sql.Date;
import perpustakaan.util.database.Database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import perpustakaan.util.Util;
import javax.swing.JOptionPane;

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
                    "UPDATE peminjaman SET waktu_kembali = ? WHERE id_peminjaman = ? AND waktu_kembali = null"
            );
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar waktu = Calendar.getInstance();
            
            pstmt.setString(1, dateFormat.format(waktu.getTime()));
            pstmt.setInt(2, 938300);
            pstmt.executeUpdate();
            
        }catch(SQLException ex){
            Util.handleException(ex);
            
            //JOptionPane.showMessageDialog(null, "Kode buku yang diinputkan sudah ada!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
