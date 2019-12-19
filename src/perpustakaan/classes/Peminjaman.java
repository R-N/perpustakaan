/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.classes;

import perpustakaan.util.Util;
import perpustakaan.util.database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 *
 * @author ARION
 */
public class Peminjaman {
    Integer idPeminjaman;
    String kodeBuku;
    String namaPeminjam;
    String teleponPeminjam;
    String alamatPeminjam;
    String waktuPinjam;
    String waktuTenggang;
    String waktuKembali;
    
    public Peminjaman(Integer idPeminjaman, String kodeBuku, String namaPeminjam, String teleponPeminjam, String alamatPeminjam, String waktuPinjam, String waktuTenggang, String waktuKembali) {
        this(kodeBuku, namaPeminjam, teleponPeminjam, alamatPeminjam, waktuTenggang);
        this.waktuKembali = waktuKembali;
        this.waktuPinjam = waktuPinjam;
        this.idPeminjaman = idPeminjaman;
    }
    
    public Peminjaman(String kodeBuku, String namaPeminjam, String teleponPeminjam, String alamatPeminjam, String waktuTenggang) {
        
        this.kodeBuku = kodeBuku;
        this.namaPeminjam = namaPeminjam;
        this.teleponPeminjam = teleponPeminjam;
        this.waktuTenggang = waktuTenggang;
    }
    public static List<Peminjaman> fetchRiwayat(){
        try{
            PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT id_peminjaman, kode_buku, nama_peminjam, telepon_peminjam, alamat_peminjam, waktu_pinjam, waktu_tenggang, waktu_kembali FROM peminjaman ORDER BY waktu_pinjam DESC"
            );
            
            ResultSet rs = pstmt.executeQuery();
            List<Peminjaman> ret = new ArrayList<Peminjaman>();
            while(rs.next()){
                ret.add(new Peminjaman(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
            return ret;
        }catch(SQLException ex){
            Util.handleException(ex);
            return null;
        }
    }
    public static List<Peminjaman> fetchPeminjaman(){
        try{
            PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT id_peminjaman, kode_buku, nama_peminjam, telepon_peminjam, alamat_peminjam, waktu_pinjam, waktu_tenggang, waktu_kembali FROM peminjaman WHERE waktuKembali IS NULL ORDER BY waktu_pinjam DESC"
            );
            
            ResultSet rs = pstmt.executeQuery();
            List<Peminjaman> ret = new ArrayList<Peminjaman>();
            while(rs.next()){
                ret.add(new Peminjaman(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                ));
            }
            return ret;
        }catch(SQLException ex){
            Util.handleException(ex);
            return null;
        }
    }
    public boolean insert(){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "INSERT INTO peminjaman (kode_buku, nama_peminjam, telepon_peminjam, alamat_peminjam, waktu_pinjam, waktu_tenggang)"
                            + "VALUES (?, ?, ?, ?, ?, ?)"
            );

            pstmt.setString(1, kodeBuku);
            pstmt.setString(2, namaPeminjam);
            pstmt.setString(3, teleponPeminjam);
            pstmt.setString(4, alamatPeminjam);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar waktu = Calendar.getInstance();
            waktuPinjam =  dateFormat.format(waktu.getTime());
            pstmt.setString(5, waktuPinjam);
            pstmt.setString(6, waktuTenggang);
            
            boolean ret =  pstmt.executeUpdate() > 0;
            
            if(ret){
                ResultSet keys = pstmt.getGeneratedKeys();
                keys.next();
                this.idPeminjaman = keys.getInt(1);
                Database.commit();
            }else{
                Database.rollback();
            }
            
            return ret;
        }catch(SQLException ex){
            Util.handleException(ex);
            return false;
        }
    }
    
    public boolean kembalikan(){
        try{
            PreparedStatement pstmt = Database.prepareStatement(
                    "UPDATE peminjaman SET waktu_kembali = ? WHERE id_peminjaman = ? AND waktu_kembali = null"
            );
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar waktu = Calendar.getInstance();
            waktuKembali = dateFormat.format(waktu.getTime());
            pstmt.setString(1, waktuKembali);
            pstmt.setInt(2, idPeminjaman);
            boolean ret = pstmt.executeUpdate() > 0;
            
            if(!ret){
                Database.rollback();
                return false;
            }
            
            pstmt = Database.prepareStatement(
                    "UPDATE buku SET status_buku = 0 WHERE kode_buku=? AND status_buku=1"
            );
            pstmt.setString(1, kodeBuku);
            ret = pstmt.executeUpdate() > 0;
            
            if(ret){
                Database.commit();
            }else{
                Database.rollback();
            }
            return ret;
        }catch(SQLException ex){
            Util.handleException(ex);
            return false;
        }
    }    
   
}
