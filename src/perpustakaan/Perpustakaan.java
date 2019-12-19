/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.formdev.flatlaf.FlatLightLaf;
import java.io.File;
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
        
        String directoryName = "covers/";


        File directory = new File(String.valueOf(directoryName));

        if(!directory.exists()){
             directory.mkdir();
        }

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
