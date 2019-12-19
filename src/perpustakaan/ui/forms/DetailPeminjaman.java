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
public class DetailPeminjaman extends javax.swing.JPanel {

    /**
     * Creates new form DetailBukuPanel
     */
    public DetailPeminjaman() {
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
        btnKembali = new javax.swing.JButton();
        tabel = new javax.swing.JPanel();
        tabelkiri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSudahKembali = new javax.swing.JButton();
        tabelkanan = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        kodeBuku = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kodePinjam = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        namaPeminjam = new javax.swing.JLabel();
        nomerPeminjam = new javax.swing.JLabel();
        alamatPeminjam = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(0, 0));
        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        headerKiri.setOpaque(false);
        headerKiri.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Source Sans Pro Semibold", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(40, 38, 78));
        jLabel4.setText("Daftar Peminjaman / Detail Peminjaman");
        jLabel4.setMinimumSize(new java.awt.Dimension(0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        headerKiri.add(jLabel4, gridBagConstraints);

        btnKembali.setBackground(new java.awt.Color(218, 219, 230));
        btnKembali.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        btnKembali.setForeground(new java.awt.Color(85, 89, 114));
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/perpustakaan/ui/gambar/icon/kembali.png"))); // NOI18N
        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });
        headerKiri.add(btnKembali, new java.awt.GridBagConstraints());

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
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 0, 20);
        tabelkiri.add(jLabel1, gridBagConstraints);

        btnSudahKembali.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        btnSudahKembali.setText("Sudah Kembali");
        btnSudahKembali.setMinimumSize(new java.awt.Dimension(0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 10);
        tabelkiri.add(btnSudahKembali, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
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
        jLabel6.setText("Kode Peminjaman");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(jLabel6, gridBagConstraints);

        kodePinjam.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        kodePinjam.setForeground(new java.awt.Color(84, 88, 113));
        kodePinjam.setText("kdpinjam");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(kodePinjam, gridBagConstraints);

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

        namaPeminjam.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        namaPeminjam.setForeground(new java.awt.Color(84, 88, 113));
        namaPeminjam.setText("nama");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(namaPeminjam, gridBagConstraints);

        nomerPeminjam.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        nomerPeminjam.setForeground(new java.awt.Color(84, 88, 113));
        nomerPeminjam.setText("nomer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(nomerPeminjam, gridBagConstraints);

        alamatPeminjam.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        alamatPeminjam.setForeground(new java.awt.Color(84, 88, 113));
        alamatPeminjam.setText("alamat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(alamatPeminjam, gridBagConstraints);

        tgl.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        tgl.setForeground(new java.awt.Color(84, 88, 113));
        tgl.setText("tgl");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        tabelkanan.add(tgl, gridBagConstraints);

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

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        // TODO add your handling code here:
        parent.showCard("daftarbuku");
    }//GEN-LAST:event_btnKembaliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alamatPeminjam;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSudahKembali;
    private javax.swing.JPanel headerKiri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel kodeBuku;
    private javax.swing.JLabel kodePinjam;
    private javax.swing.JLabel namaPeminjam;
    private javax.swing.JLabel nomerPeminjam;
    private javax.swing.JPanel tabel;
    private javax.swing.JPanel tabelkanan;
    private javax.swing.JPanel tabelkiri;
    private javax.swing.JLabel tgl;
    // End of variables declaration//GEN-END:variables
}
