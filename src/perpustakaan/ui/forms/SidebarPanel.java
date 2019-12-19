/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.ui.forms;

import perpustakaan.ui.classes.ImagePanel;

/**
 *
 * @author nick
 */
public class SidebarPanel extends ImagePanel {

    /**
     * Creates new form sidebar
     */
    MainPanel parent;
    
    public SidebarPanel() {
        initComponents();
        setImage("background.png");
    }
    
    public void setParent(MainPanel parent){
        this.parent = parent;
        
    }

    public void init(MainPanel parent){
        setParent(parent);
    }
    
    public void select(String card){
        parent.showCard(card);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        myBookButton = new javax.swing.JLabel();
        daftarPeminjamanButton = new javax.swing.JLabel();
        riwayatPeminjamanButton = new javax.swing.JLabel();
        logoutButton = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(new java.awt.Color(240, 230, 240));
        jLabel1.setFont(new java.awt.Font("Source Sans Pro", 1, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 230, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("E - Library");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        add(jLabel1, gridBagConstraints);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        myBookButton.setFont(new java.awt.Font("Source Sans Pro", 1, 24)); // NOI18N
        myBookButton.setForeground(new java.awt.Color(240, 230, 240));
        myBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaan/ui/gambar/icon/my book.png"))); // NOI18N
        myBookButton.setText("  My Book");
        myBookButton.setAlignmentX(0.5F);
        myBookButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myBookButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        jPanel1.add(myBookButton, gridBagConstraints);

        daftarPeminjamanButton.setFont(new java.awt.Font("Source Sans Pro", 1, 24)); // NOI18N
        daftarPeminjamanButton.setForeground(new java.awt.Color(240, 230, 240));
        daftarPeminjamanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaan/ui/gambar/icon/daftar pinjam.png"))); // NOI18N
        daftarPeminjamanButton.setText("  Daftar Peminjaman");
        daftarPeminjamanButton.setAlignmentX(0.5F);
        daftarPeminjamanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                daftarPeminjamanButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        jPanel1.add(daftarPeminjamanButton, gridBagConstraints);

        riwayatPeminjamanButton.setFont(new java.awt.Font("Source Sans Pro", 1, 24)); // NOI18N
        riwayatPeminjamanButton.setForeground(new java.awt.Color(240, 230, 240));
        riwayatPeminjamanButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaan/ui/gambar/icon/riwayat.png"))); // NOI18N
        riwayatPeminjamanButton.setText("  Riwayat Peminjaman");
        riwayatPeminjamanButton.setAlignmentX(0.5F);
        riwayatPeminjamanButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                riwayatPeminjamanButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        jPanel1.add(riwayatPeminjamanButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 0, 0);
        add(jPanel1, gridBagConstraints);

        logoutButton.setFont(new java.awt.Font("Source Sans Pro", 1, 24)); // NOI18N
        logoutButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaan/ui/gambar/icon/Logout.png"))); // NOI18N
        logoutButton.setMinimumSize(new java.awt.Dimension(0, 0));
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        add(logoutButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void daftarPeminjamanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarPeminjamanButtonMouseClicked
        // TODO add your handling code here:
        select("daftarpeminjaman");
    }//GEN-LAST:event_daftarPeminjamanButtonMouseClicked

    private void myBookButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myBookButtonMouseClicked
        // TODO add your handling code here:
        select("daftarbuku");
    }//GEN-LAST:event_myBookButtonMouseClicked

    private void riwayatPeminjamanButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_riwayatPeminjamanButtonMouseClicked
        // TODO add your handling code here:
        select("riwayatpeminjaman");
    }//GEN-LAST:event_riwayatPeminjamanButtonMouseClicked

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        // TODO add your handling code here:
        parent.logout();
    }//GEN-LAST:event_logoutButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel daftarPeminjamanButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoutButton;
    private javax.swing.JLabel myBookButton;
    private javax.swing.JLabel riwayatPeminjamanButton;
    // End of variables declaration//GEN-END:variables
}
