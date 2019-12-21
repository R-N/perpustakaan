/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.ui.forms;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument;
import perpustakaan.classes.Buku;
import perpustakaan.ui.classes.IMainPanel;
import perpustakaan.ui.classes.LimitDocumentFilter;
import perpustakaan.util.Util;

/**
 *
 * @author LENOVO
 */
public class TambahBukuPanel extends javax.swing.JPanel implements IMainPanel {

    /**
     * Creates new form TambahBukuPanel
     */
    
    Buku buku = null;
    File cover = null;
    
    public TambahBukuPanel() {
        initComponents();
        ((AbstractDocument)kodeBukuField.getDocument()).setDocumentFilter(new LimitDocumentFilter(6));
        ((AbstractDocument)judulBukuField.getDocument()).setDocumentFilter(new LimitDocumentFilter(50));
        ((AbstractDocument)penulisBukuField.getDocument()).setDocumentFilter(new LimitDocumentFilter(50));
    }
    
    

    MainPanel parent;
    public void setParent(MainPanel parent){
        this.parent = parent;
        
    }

    public void init(MainPanel parent){
        setParent(parent);
    }
    
    @Override
    public void refresh() {
        load(null);
    }

    @Override
    public void load(Object object) {
        if(object == null){
            this.buku = null;
            kodeBukuField.setText("");
            kodeBukuField.setEditable(true);
            judulBukuField.setText("");
            penulisBukuField.setText("");
            titleLabel.setText("My Book / Tambah Buku");
            coverButton.setText("Upload a photo");
            return;
        }
        if(object instanceof Buku){
            this.buku = (Buku)object;
            kodeBukuField.setText(buku.kodeBuku);
            kodeBukuField.setEditable(false);
            judulBukuField.setText(buku.judulBuku);
            penulisBukuField.setText(buku.penulisBuku);
            titleLabel.setText("My Book / Edit Buku");
            String cover = buku.findCoverFileName();
            if(cover == null){
                coverButton.setText("Upload a photo");
            }else{
                coverButton.setText(cover);
            }
        }
    }

    public void pilihCover(){
        File f = Util.getImagePath();
        if(f == null) return;
        if(this.cover != null){
            
        }
        this.cover = f;
        coverButton.setText(cover.getName());
    }
    
    @Override
    public JPanel getPanel() {
        return this;
    }
    
    public Buku read(){
        String judulBuku = judulBukuField.getText();
        if(Util.isNullOrEmpty(judulBuku)){
            Util.showError("Judul tidak boleh kosong", "Error");
            return null;
        }
        String penulisBuku = penulisBukuField.getText();
        if(Util.isNullOrEmpty(penulisBuku)){
            Util.showError("Penulis tidak boleh kosong", "Error");
            return null;
        }
        String kodeBuku = kodeBukuField.getText();
        if(Util.isNullOrEmpty(kodeBuku)){
            Util.showError("Kode Buku tidak boleh kosong", "Error");
            return null;
        }

        Buku buku1 = new Buku(
                kodeBuku,
                judulBuku,
                penulisBuku
        );
        if(this.buku == null){
            return buku1;
        }else{
            return buku.clone().read(buku1);
        }
    }
    public boolean tambahBuku(){
        Buku buku = read();
        
        if(buku == null) return false;
        
        if(!Util.askConfirmation("Apakah data buku sudah benar?", "Simpan Buku")) return false;
        
        boolean ret = buku.insert();
        
        if(ret){
            copyCover(buku);
        }
        
        return ret;
    }
    
    public boolean updateBuku(){
        Buku buku1 = read();
        if(buku1 == null) return false;
        if (buku.equals(buku1)){
            copyCover(buku);
            return true;
        }
        if(!Util.askConfirmation("Apakah data buku sudah benar?", "Simpan Buku")) return false;
        
        boolean ret = buku1.update();
        
        if(ret){
            copyCover(buku1);
        }
        
        return ret;
    }
    
    public void copyCover(Buku buku){
        if(cover == null) return;
        try{
            Path newPath = cover.toPath();
            Path oldPath = buku.findCoverPathPath();
            if(oldPath != null){
                Files.delete(oldPath);
            }
            Path copied = Paths.get("covers/" + buku.kodeBuku + "." + Util.splitFileName(newPath.getFileName().toString())[1]);
            Files.copy(newPath, copied, StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException ex){
            Util.handleException(ex);
        }
    }
    
    public boolean simpanBuku(){
        if(this.buku == null){
            return tambahBuku();
        }else{
            return updateBuku();
        }
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

        Header = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        tabel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        kodeBukuField = new javax.swing.JTextField();
        judulBukuField = new javax.swing.JTextField();
        penulisBukuField = new javax.swing.JTextField();
        coverButton = new javax.swing.JLabel();
        Footer = new javax.swing.JPanel();
        batalButton = new javax.swing.JButton();
        simpanButton = new javax.swing.JButton();

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        Header.setOpaque(false);
        Header.setLayout(new java.awt.GridBagLayout());

        titleLabel.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(84, 88, 113));
        titleLabel.setText("My Book / Tambah Buku");
        titleLabel.setMinimumSize(new java.awt.Dimension(0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        Header.add(titleLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        add(Header, gridBagConstraints);

        tabel.setBackground(new java.awt.Color(255, 255, 255));
        tabel.setOpaque(false);
        tabel.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(84, 88, 113));
        jLabel3.setText("Kode Buku");
        jLabel3.setMinimumSize(new java.awt.Dimension(0, 0));
        jLabel3.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        tabel.add(jLabel3, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(84, 88, 113));
        jLabel6.setText("Judul Buku");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        tabel.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(84, 88, 113));
        jLabel7.setText("Penulis");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        tabel.add(jLabel7, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(84, 88, 113));
        jLabel10.setText("Upload Foto Buku");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        tabel.add(jLabel10, gridBagConstraints);

        kodeBukuField.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        kodeBukuField.setForeground(new java.awt.Color(84, 88, 113));
        kodeBukuField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeBukuFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        tabel.add(kodeBukuField, gridBagConstraints);

        judulBukuField.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        judulBukuField.setForeground(new java.awt.Color(84, 88, 113));
        judulBukuField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judulBukuFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        tabel.add(judulBukuField, gridBagConstraints);

        penulisBukuField.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        penulisBukuField.setForeground(new java.awt.Color(84, 88, 113));
        penulisBukuField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penulisBukuFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        tabel.add(penulisBukuField, gridBagConstraints);

        coverButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        coverButton.setForeground(new java.awt.Color(114, 100, 139));
        coverButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaan/ui/gambar/icon/upload.png"))); // NOI18N
        coverButton.setText(" Upload a photo");
        coverButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coverButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        tabel.add(coverButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(tabel, gridBagConstraints);

        Footer.setOpaque(false);
        Footer.setLayout(new java.awt.GridBagLayout());

        batalButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        batalButton.setForeground(new java.awt.Color(84, 88, 113));
        batalButton.setText("Batal");
        batalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        Footer.add(batalButton, gridBagConstraints);

        simpanButton.setBackground(new java.awt.Color(84, 88, 113));
        simpanButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        simpanButton.setForeground(new java.awt.Color(204, 204, 204));
        simpanButton.setText("Simpan Buku");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        Footer.add(simpanButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 10.0;
        add(Footer, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void kodeBukuFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeBukuFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodeBukuFieldActionPerformed

    private void judulBukuFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judulBukuFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_judulBukuFieldActionPerformed

    private void penulisBukuFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penulisBukuFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penulisBukuFieldActionPerformed

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        // TODO add your handling code here:
        parent.showCard("daftarbuku");
    }//GEN-LAST:event_batalButtonActionPerformed

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        // TODO add your handling code here:
        if(simpanBuku()){
            parent.showCard("daftarbuku");
        }else{
            
        }
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void coverButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coverButtonMouseClicked
        // TODO add your handling code here:
        pilihCover();
    }//GEN-LAST:event_coverButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Footer;
    private javax.swing.JPanel Header;
    private javax.swing.JButton batalButton;
    private javax.swing.JLabel coverButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField judulBukuField;
    private javax.swing.JTextField kodeBukuField;
    private javax.swing.JTextField penulisBukuField;
    private javax.swing.JButton simpanButton;
    private javax.swing.JPanel tabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
