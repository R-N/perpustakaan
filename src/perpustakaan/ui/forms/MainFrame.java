/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.ui.forms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import perpustakaan.classes.LoginManager;
import perpustakaan.util.Util;
import perpustakaan.util.database.Database;

/**
 *
 * @author LENOVO
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    
    public MainFrame() {
        initComponents();
    }
    
    public void init(){
        loginPanel.init(this);
        mainPanel.init(this);
        
        showCard("login");
    }
    
    public void showCard(String card){
        rootLayout.show(rootPanel, card);
    }
    
    public void logout(){
        LoginManager.logout();
        showCard("login");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel5 = new javax.swing.JPanel();
        rootPanel = new javax.swing.JPanel();
        loginPanel = new perpustakaan.ui.forms.LoginPanel();
        mainPanel = new perpustakaan.ui.forms.MainPanel();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        rootPanel.setLayout(new java.awt.CardLayout());
        rootLayout = new java.awt.CardLayout();
        rootPanel.setLayout(rootLayout);
        rootPanel.add(loginPanel, "login");
        rootPanel.add(mainPanel, "main");

        getContentPane().add(rootPanel, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel5;
    private perpustakaan.ui.forms.LoginPanel loginPanel;
    private perpustakaan.ui.forms.MainPanel mainPanel;
    private javax.swing.JPanel rootPanel;
    private java.awt.CardLayout rootLayout;
    // End of variables declaration//GEN-END:variables
}
