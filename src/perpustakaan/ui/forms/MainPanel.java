/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.ui.forms;

import java.util.HashMap;
import java.util.Map;
import perpustakaan.classes.Buku;
import perpustakaan.ui.classes.IMainPanel;

/**
 *
 * @author LENOVO
 */
public class MainPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainPanel
     */
    Map<String, IMainPanel> panels = new HashMap<String, IMainPanel>();
    
    public MainPanel() {
        initComponents();
    }
    
    public void init(MainFrame parent){
        init();
        
    }
    
    String currentCard = null;
    String previousCard = null;
    
    public void init(){
        sidebarPanel.init(this);
        
        panels.put("daftarbuku", daftarBukuPanel);
        panels.put("daftarpeminjaman", daftarPeminjamanPanel);
        panels.put("detailbuku", detailBukuPanel);
        panels.put("riwayatpeminjaman", riwayatPeminjamanPanel);
        panels.put("tambahbuku", tambahBukuPanel);
        
        for(IMainPanel panel : panels.values()){
            panel.init(this);
        }
        
        showCard("daftarbuku");
    }
    
    public void showBuku(Buku buku){
        showCard("detailbuku");
        detailBukuPanel.load(buku);
    }
    public void editBuku(Buku buku){
        showCard("tambahbuku");
        tambahBukuPanel.load(buku);
    }
    
    public void showCard(String card){
        panels.get(card).refresh();
        previousCard = currentCard;
        currentCard = card;
        mainLayout.show(mainPanel, card);
    }
    
    public void previousCard(){
        if(previousCard == null) return;
        showCard(previousCard);
        previousCard = null;
    }
        
    public void logout(){
        
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

        sidebarPanel = new perpustakaan.ui.forms.SidebarPanel();
        mainPanel = new javax.swing.JPanel();
        daftarBukuPanel = new perpustakaan.ui.forms.DaftarBukuPanel();
        daftarPeminjamanPanel = new perpustakaan.ui.forms.DaftarPeminjamanPanel();
        detailBukuPanel = new perpustakaan.ui.forms.DetailBukuPanel();
        riwayatPeminjamanPanel = new perpustakaan.ui.forms.RiwayatPeminjamanPanel();
        tambahBukuPanel = new perpustakaan.ui.forms.TambahBukuPanel();

        setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.3;
        add(sidebarPanel, gridBagConstraints);

        mainPanel.setBackground(new java.awt.Color(247, 236, 235));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        mainPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        mainPanel.setPreferredSize(new java.awt.Dimension(820, 768));
        mainPanel.setLayout(new java.awt.CardLayout());
        mainLayout = new java.awt.CardLayout();
        mainPanel.setLayout(mainLayout);
        mainPanel.add(daftarBukuPanel, "daftarbuku");
        mainPanel.add(daftarPeminjamanPanel, "daftarpeminjaman");
        mainPanel.add(detailBukuPanel, "detailbuku");
        mainPanel.add(riwayatPeminjamanPanel, "riwayatpeminjaman");
        mainPanel.add(tambahBukuPanel, "tambahbuku");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.7;
        gridBagConstraints.weighty = 1.0;
        add(mainPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private perpustakaan.ui.forms.DaftarBukuPanel daftarBukuPanel;
    private perpustakaan.ui.forms.DaftarPeminjamanPanel daftarPeminjamanPanel;
    private perpustakaan.ui.forms.DetailBukuPanel detailBukuPanel;
    private javax.swing.JPanel mainPanel;
    java.awt.CardLayout mainLayout;
    private perpustakaan.ui.forms.RiwayatPeminjamanPanel riwayatPeminjamanPanel;
    private perpustakaan.ui.forms.SidebarPanel sidebarPanel;
    private perpustakaan.ui.forms.TambahBukuPanel tambahBukuPanel;
    // End of variables declaration//GEN-END:variables
}
