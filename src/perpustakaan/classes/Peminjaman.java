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
    public Integer idPeminjaman;
    public String kodeBuku;
    public String namaPeminjam;
    public String teleponPeminjam;
    public String alamatPeminjam;
    public String waktuPinjam;
    public String waktuTenggang;
    public String waktuKembali;
    
    public Peminjaman(Integer idPeminjaman, String kodeBuku, String namaPeminjam, String teleponPeminjam, String alamatPeminjam, String waktuPinjam, String waktuTenggang, String waktuKembali) {
        this(kodeBuku, namaPeminjam, teleponPeminjam, alamatPeminjam, waktuTenggang);
        this.waktuKembali = waktuKembali;
        this.waktuPinjam = waktuPinjam;
        this.idPeminjaman = idPeminjaman;
    }
    
    public Peminjaman(String kodeBuku, String namaPeminjam, String teleponPeminjam, String alamatPeminjam, String waktuTenggang) {
        this(namaPeminjam, teleponPeminjam, alamatPeminjam, waktuTenggang);
        this.kodeBuku = kodeBuku;
    }
    public Peminjaman(String namaPeminjam, String teleponPeminjam, String alamatPeminjam, String waktuTenggang) {
        
        this.namaPeminjam = namaPeminjam;
        this.teleponPeminjam = teleponPeminjam;
        this.alamatPeminjam = alamatPeminjam;
        this.waktuTenggang = waktuTenggang;
    }
    public static List<Peminjaman> fetchRiwayat(){
        return fetchRiwayat("");
    }
    public static List<Peminjaman> fetchRiwayat(String search){
        try{
            String sql = 
                    "SELECT id_peminjaman, kode_buku, nama_peminjam, telepon_peminjam, alamat_peminjam, waktu_pinjam, waktu_tenggang, waktu_kembali "
                            + "FROM PEMINJAMAN_SEARCH WHERE waktu_kembali IS NOT NULL ";
            if(!Util.isNullOrEmpty(search)){
                sql = sql + " AND PEMINJAMAN_SEARCH MATCH ? ";
            }
            sql = sql + " ORDER BY id_peminjaman DESC";
            PreparedStatement pstmt = Database.prepareStatement(sql);
            if(!Util.isNullOrEmpty(search)){
                pstmt.setString(1, search);
            }
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
    public Buku getBuku(){
        return Buku.getBuku(kodeBuku);
    }
    public static List<Peminjaman> fetchPeminjaman(){
        return fetchPeminjaman("");
    }
    public static List<Peminjaman> fetchPeminjaman(String search){
        try{
            String sql = "SELECT id_peminjaman, kode_buku, nama_peminjam, telepon_peminjam, alamat_peminjam, waktu_pinjam, waktu_tenggang, waktu_kembali "
                            + "FROM PEMINJAMAN_SEARCH WHERE waktu_kembali IS NULL ";
            if(!Util.isNullOrEmpty(search)){
                sql = sql + " AND PEMINJAMAN_SEARCH MATCH ? ";
            }
            sql = sql + " ORDER BY id_peminjaman DESC";
            PreparedStatement pstmt = Database.prepareStatement(sql);
            if(!Util.isNullOrEmpty(search)){
                pstmt.setString(1, search);
            }
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
    
    public boolean refresh(){
        try{
            PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT id_peminjaman, kode_buku, nama_peminjam, telepon_peminjam, alamat_peminjam, waktu_pinjam, waktu_tenggang, waktu_kembali FROM peminjaman WHERE id_peminjaman=? ORDER BY waktu_pinjam DESC"
            );
            pstmt.setInt(1, idPeminjaman);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                idPeminjaman = rs.getInt(1);
                kodeBuku = rs.getString(2);
                namaPeminjam = rs.getString(3);
                teleponPeminjam = rs.getString(4);
                alamatPeminjam = rs.getString(5);
                waktuPinjam = rs.getString(6);
                waktuTenggang = rs.getString(7);
                waktuKembali = rs.getString(8);
                return true;
            }
        }catch(SQLException ex){
            Util.handleException(ex);
        }
        return false;
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
                    "UPDATE peminjaman SET waktu_kembali = ? WHERE id_peminjaman = ? AND waktu_kembali IS NULL"
            );
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar waktu = Calendar.getInstance();
            waktuKembali = dateFormat.format(waktu.getTime());
            pstmt.setString(1, waktuKembali);
            pstmt.setInt(2, idPeminjaman);
            boolean ret = pstmt.executeUpdate() > 0;
            
            if(!ret){
                Database.rollback();
                throw new SQLException("Gagal update waktu pengembalian " + idPeminjaman + " " + waktuKembali);
            }
            
            pstmt = Database.prepareStatement(
                    "UPDATE buku SET status_buku = 0 WHERE kode_buku=? AND status_buku=1"
            );
            pstmt.setString(1, kodeBuku);
            ret = pstmt.executeUpdate() > 0;
            
            if(!ret){
                pstmt = Database.prepareStatement(
                        "SELECT COUNT(*) FROM BUKU WHERE kode_buku=?"
                );
                pstmt.setString(1, kodeBuku);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                if(rs.getInt(1) == 0){
                    ret = true;
                }
            }
            
            if(ret){
                Database.commit();
            }else{
                Database.rollback();
                throw new SQLException("Gagal update status buku");
            }
            return ret;
        }catch(SQLException ex){
            Util.handleException(ex);
            return false;
        }
    }    
   
    public Object[] toArrayDaftar(){
        return new Object[]{
            kodeBuku,
            idPeminjaman,
            namaPeminjam,
            waktuPinjam.split(" ")[0],
            waktuTenggang.split(" ")[0]
        };
    }
    
    public Object[] toArrayRiwayat(){
        return new Object[]{
            kodeBuku,
            idPeminjaman,
            namaPeminjam,
            waktuPinjam.split(" ")[0],
            waktuKembali.split(" ")[0]
        };
    }
}
