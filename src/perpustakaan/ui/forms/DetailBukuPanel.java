/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.ui.forms;

/**
 *
 * @author LENOVO
 */
public class DetailBukuPanel extends javax.swing.JPanel {

    /**
     * Creates new form DetailBukuPanel
     */
    public DetailBukuPanel() {
        initComponents();
    }

    MainPanel parent;
    public void setParent(MainPanel parent){
        this.parent = parent;
        
    }

    public void init(MainPanel parent){
        setParent(parent);
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

        headerKiri = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        kembaliButton = new javax.swing.JButton();
        tabel = new javax.swing.JPanel();
        tabelkiri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPinjam = new javax.swing.JButton();
        tabelkanan = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        kodeBuku = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        judulBuku = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        namaPenulis = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldNama = new javax.swing.JTextField();
        jTextFieldNomer = new javax.swing.JTextField();
        jTextFieldAlamat = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();

        setMinimumSize(new java.awt.Dimension(0, 0));
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        headerKiri.setOpaque(false);
        headerKiri.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(40, 38, 78));
        jLabel4.setText("My Book / Detail Buku");
        jLabel4.setMinimumSize(new java.awt.Dimension(0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        headerKiri.add(jLabel4, gridBagConstraints);

        kembaliButton.setBackground(new java.awt.Color(218, 219, 230));
        kembaliButton.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        kembaliButton.setForeground(new java.awt.Color(85, 89, 114));
        kembaliButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaan/ui/gambar/icon/kembali.png"))); // NOI18N
        kembaliButton.setText("Kembali");
        kembaliButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliButtonActionPerformed(evt);
            }
        });
        headerKiri.add(kembaliButton, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        add(headerKiri, gridBagConstraints);

        tabel.setBackground(new java.awt.Color(255, 255, 255));
        tabel.setMinimumSize(new java.awt.Dimension(0, 0));
        tabel.setLayout(new java.awt.GridBagLayout());

        tabelkiri.setBackground(new java.awt.Color(255, 255, 255));
        tabelkiri.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaan/ui/gambar/cover.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        tabelkiri.add(jLabel1, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(84, 88, 113));
        jButton1.setForeground(new java.awt.Color(247, 236, 235));
        jButton1.setText("Pinjam Buku");
        jButton1.setMinimumSize(new java.awt.Dimension(0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        tabelkiri.add(jButton1, gridBagConstraints);
		
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 0);
        tabel.add(tabelkiri, gridBagConstraints);

        tabelkanan.setBackground(new java.awt.Color(255, 255, 255));
        tabelkanan.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(84, 88, 113));
        jLabel3.setText("Kode Buku");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(jLabel3, gridBagConstraints);

        kodeBuku.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        kodeBuku.setForeground(new java.awt.Color(84, 88, 113));
        kodeBuku.setText("kdbuku");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(kodeBuku, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(84, 88, 113));
        jLabel6.setText("Judul Buku");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(jLabel6, gridBagConstraints);

        judulBuku.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        judulBuku.setForeground(new java.awt.Color(84, 88, 113));
        judulBuku.setText("jdlBuku");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(judulBuku, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(84, 88, 113));
        jLabel8.setText("Nama Penulis Buku");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(jLabel8, gridBagConstraints);

        namaPenulis.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        namaPenulis.setForeground(new java.awt.Color(84, 88, 113));
        namaPenulis.setText("nmPenulis");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(namaPenulis, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(84, 88, 113));
        jLabel10.setText("Nama Peminjam");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(jLabel10, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(84, 88, 113));
        jLabel11.setText("No. Telepon Peminjam");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(jLabel11, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(84, 88, 113));
        jLabel12.setText("Alamat Peminjam");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(jLabel12, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(84, 88, 113));
        jLabel13.setText("Masa Tenggang Peminjaman");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(jLabel13, gridBagConstraints);

        jTextFieldNama.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(jTextFieldNama, gridBagConstraints);

        jTextFieldNomer.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(jTextFieldNomer, gridBagConstraints);

        jTextFieldAlamat.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(jTextFieldAlamat, gridBagConstraints);

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(jFormattedTextField1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 7.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        tabel.add(tabelkanan, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weighty = 1.0;
        add(tabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliButtonActionPerformed
        // TODO add your handling code here:
        parent.previousCard();
    }//GEN-LAST:event_kembaliButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnPinjam;
    private javax.swing.JPanel headerKiri;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextFieldAlamat;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldNomer;
    private javax.swing.JLabel judulBuku;
    private javax.swing.JLabel kodeBuku;
    private javax.swing.JLabel namaPenulis;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton kembaliButton;
    private javax.swing.JPanel tabel;
    private javax.swing.JPanel tabelkanan;
    private javax.swing.JPanel tabelkiri;
    // End of variables declaration//GEN-END:variables
}
