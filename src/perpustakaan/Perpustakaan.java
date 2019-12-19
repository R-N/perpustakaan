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

import com.formdev.flatlaf.FlatLightLaf;
import perpustakaan.util.database.Database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.UIManager;
import perpustakaan.ui.forms.MainFrame;
import perpustakaan.util.Config;

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
		}
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Util.handleException(ex);
            
            //JOptionPane.showMessageDialog(null, "Kode buku yang diinputkan sudah ada!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
        //</editor-fold>
        Config.init();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                frame.init();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    
}
