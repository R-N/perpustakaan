/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import perpustakaan.util.database.Database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import perpustakaan.util.Util;

/**
 *
 * @author ARION
 */
public class Buku {
    public String kodeBuku;
    public String judulBuku;
    public String penulisBuku;
    public int statusBuku;
    
    public Buku(String kodeBuku, String judulBuku, String penulisBuku){
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.penulisBuku = penulisBuku;
    }
    
    public boolean cariBuku(){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT * FROM buku WHERE kode_buku = %?% OR judul_buku = %?% OR penulis_buku = %?%"
            );
            
            pstmt.setString(1, kodeBuku);
            pstmt.setString(2, judulBuku);
            pstmt.setString(3, penulisBuku);
            return pstmt.execute();
        }catch (SQLException ex){
            Util.handleException(ex);
            return false;
        }
    }
    
    public boolean tampilBuku(){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT kode_buku, judul_buku, nama_penulis, status_buku FROM buku WHERE kode_buku = ?"
            );
            
            pstmt.setString(1, kodeBuku);
            return pstmt.execute();
        }catch (SQLException ex){
            Util.handleException(ex);
            return false;
        }
    }
    
    public boolean pinjam(Peminjaman peminjaman){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "UPDATE buku SET status_buku = ? WHERE kode_buku = ?"
                    
            );
            pstmt.setInt(1, 1);
            pstmt.setString(2, kodeBuku);
            
            java.sql.PreparedStatement pstmt2 = Database.prepareStatement(
                    "UPDATE peminjaman SET kode_buku = ? WHERE id_peminjaman = ?"
            );
            Integer idPeminjaman = peminjaman.idPeminjaman;
            pstmt2.setString(1, kodeBuku);
            pstmt2.setInt(2, idPeminjaman);
            
            
            return pstmt.executeUpdate() == 0;
        }catch(SQLException ex){
            Util.handleException(ex);
            return false;
        }    
    }
    
    public boolean kembalikan(Peminjaman peminjaman){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "UPDATE peminjaman SET kode_buku = ? WHERE id_peminjaman = ? AND waktu_kembali = NULL"
            );
            Integer idPeminjaman = peminjaman.idPeminjaman;
            String waktuKembali = peminjaman.waktuKembali;
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar waktu = Calendar.getInstance();
            waktuKembali =  dateFormat.format(waktu.getTime());
            pstmt.setString(1, kodeBuku);
            pstmt.setInt(2, idPeminjaman);
            return pstmt.executeUpdate() == 0;
        }catch(SQLException ex){
            Util.handleException(ex);
            return false;
        }
    }
    
    public boolean insert(){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "INSERT INTO buku (kode_buku, judul_buku, penulis_buku, status_buku) VALUES(?, ?, ?, 0)"
            );
            pstmt.setString(1, kodeBuku);
            pstmt.setString(2, judulBuku);
            pstmt.setString(3, penulisBuku);
            return pstmt.executeUpdate() == 0;
        }catch(SQLException ex){
            Util.handleException(ex);
            return false;
        }
    }
    
    public boolean update(){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "UPDATE buku SET judul_buku = ?,"
                                  +"penulisBuku = ? "
                                  +"WHERE kode_buku = ?"
            );

            pstmt.setString(1, judulBuku);
            pstmt.setString(2, penulisBuku);
            pstmt.setString(3, kodeBuku);
            return pstmt.executeUpdate() == 0;
        }catch(SQLException ex){
            Util.handleException(ex);
            return false;
        }    
    }
    
    void delete(){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "DELETE FROM buku WHERE kode_buku = ?"              
            );

            pstmt.setString(1, kodeBuku);
            pstmt.executeUpdate();
        }catch(SQLException ex){
            Util.handleException(ex);
            
}
    }
}
