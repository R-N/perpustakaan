/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import perpustakaan.util.Util;
import perpustakaan.util.database.Database;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 *
 * @author ARION
 */
public class Peminjaman {
    Integer idPeminjaman;
    String namaPeminjam;
    String teleponPeminjam;
    String alamatPeminjam;
    String waktuPinjam;
    String waktuTenggang;
    String waktuKembali;
    
    public Peminjaman(Integer idPeminjaman, String namaPeminjam, String teleponPeminjam, String alamatPeminjam, String waktuPinjam, String waktuTenggang, String waktuKembali) {
        this.idPeminjaman = idPeminjaman;
        this.namaPeminjam = namaPeminjam;
        this.teleponPeminjam = teleponPeminjam;
        this.waktuPinjam = waktuPinjam;
        this.waktuTenggang = waktuTenggang;
        this.waktuKembali = waktuKembali;
    }
    
    public boolean cariRiwayat(Buku buku){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT * FROM peminjaman WHERE kode_buku = %?% OR id_peminjaman = %?% OR nama_peminjam = %?% OR waktu_pinjam = %?% OR waktu_kembali = %?%"
            );
            String kodeBuku = buku.kodeBuku;
            pstmt.setString(1, kodeBuku);
            pstmt.setInt(2, idPeminjaman);
            pstmt.setString(3, namaPeminjam);
            pstmt.setString(4, waktuPinjam);
            return pstmt.execute();
        }catch(SQLException ex){
            Util.handleException(ex);
            return false;
        }
    }
    public boolean insert(){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "INSERT INTO peminjaman (nama_peminjam, telepon_peminjam, alamat_peminjam, waktu_pinjam, waktu_tenggang)"
                            + "VALUES (?, ?, ?, ?, ?)"
            );

            pstmt.setString(1, namaPeminjam);
            pstmt.setString(2, teleponPeminjam);
            pstmt.setString(3, alamatPeminjam);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar waktu = Calendar.getInstance();
            waktuPinjam =  dateFormat.format(waktu.getTime());
            pstmt.setString(4, waktuPinjam);
            pstmt.setString(5, waktuTenggang);
            
            return pstmt.executeUpdate() == 0;
        
        }catch(SQLException ex){
            Util.handleException(ex);
            return false;
        }
    }
    
    public boolean kembalikan(){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "UPDATE peminjaman SET waktu_kembali = ? WHERE id_peminjaman = ? AND waktu_kembali = null"
            );
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar waktu = Calendar.getInstance();
            waktuKembali = dateFormat.format(waktu.getTime());
            pstmt.setString(1, waktuKembali);
            pstmt.setInt(2, idPeminjaman);
            return pstmt.executeUpdate() == 0;
        }catch(SQLException ex){
            Util.handleException(ex);
            return false;
        }
    }    
   
}
