/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.classes;

import perpustakaan.util.database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
    public Integer statusBuku;
    
    public Buku(String kodeBuku, String judulBuku, String penulisBuku){
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.penulisBuku = penulisBuku;
    }
    public Buku(String kodeBuku, String judulBuku, String penulisBuku, int statusBuku){
        this(kodeBuku, judulBuku, penulisBuku);
        this.statusBuku = statusBuku;
    }
    
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if (!(obj instanceof Buku)) return false;
        Buku buku = (Buku) obj;
        return 
                (kodeBuku == buku.kodeBuku || (kodeBuku != null && kodeBuku.equals(buku.kodeBuku)))
                && (judulBuku == buku.judulBuku || (judulBuku != null && judulBuku.equals(buku.judulBuku)))
                && (penulisBuku == buku.penulisBuku || (penulisBuku != null && penulisBuku.equals(buku.penulisBuku)))
                &&  (statusBuku == buku.statusBuku || (statusBuku != null && statusBuku.equals(buku.statusBuku)))
                ;
                
    }
    
    public Buku read(Buku buku){
        return read(buku, false);
    }
    
    public Buku read(Buku buku, boolean force){
        if(force || !Util.isNullOrEmpty(buku.kodeBuku))
            this.kodeBuku = buku.kodeBuku;
        if(force || !Util.isNullOrEmpty(buku.judulBuku))
            this.judulBuku = buku.judulBuku;
        if(force || !Util.isNullOrEmpty(buku.penulisBuku))
            this.penulisBuku = buku.penulisBuku;
        if(force || buku.statusBuku != null)
            this.statusBuku = buku.statusBuku;
        return this;
    }
    
    public Buku clone(){
        return new Buku(
                kodeBuku,
                judulBuku,
                penulisBuku,
                statusBuku
        );
    }
    
    public static List<Buku> fetchBuku(){
        try{
            PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT kode_buku, judul_buku, penulis_buku, status_buku FROM buku ORDER BY kode_buku ASC"
            );
            
            ResultSet rs =  pstmt.executeQuery();
            
            List<Buku> ret = new ArrayList<Buku>();
            while(rs.next()){
                ret.add(new Buku(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
            return ret;
        }catch (SQLException ex){
            Util.handleException(ex);
            return null;
        }
    }
    
    public static Buku getBuku(String kodeBuku){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT kode_buku, judul_buku, penulis_buku, status_buku FROM buku WHERE kode_buku = ?"
            );
            
            pstmt.setString(1, kodeBuku);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                return new Buku(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
            }
            
        }catch (SQLException ex){
            Util.handleException(ex);
        }
        return null;
    }
    
    
    public boolean refresh(){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT kode_buku, judul_buku, penulis_buku, status_buku FROM buku WHERE kode_buku = ?"
            );
            
            pstmt.setString(1, kodeBuku);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                kodeBuku = rs.getString(1);
                judulBuku = rs.getString(2);
                penulisBuku = rs.getString(3);
                statusBuku = rs.getInt(4);
                return true;
            }
            
        }catch (SQLException ex){
            Util.handleException(ex);
        }
        return false;
    }
    
    public Peminjaman getPeminjaman(){
        
        try{
            PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT id_peminjaman, kode_buku, nama_peminjam, telepon_peminjam, alamat_peminjam, waktu_pinjam, waktu_tenggang, waktu_kembali "
                            + "FROM peminjaman WHERE waktuKembali IS NULL AND kode_buku = ? ORDER BY waktu_pinjam DESC"
            );
            
            pstmt.setString(1, kodeBuku);
            
            ResultSet rs = pstmt.executeQuery();
            List<Peminjaman> ret = new ArrayList<Peminjaman>();
            if(rs.next()){
                return new Peminjaman(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
            }
            return null;
        }catch(SQLException ex){
            Util.handleException(ex);
            return null;
        }
    }
    
    public boolean pinjam(Peminjaman peminjaman){
        if(statusBuku == null){
            return false;
        }
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "UPDATE buku SET status_buku = 1 WHERE kode_buku = ? AND status_buku = 0"
                    
            );
            pstmt.setString(1, kodeBuku);
            
            if(pstmt.executeUpdate() <= 0){
                if(this.statusBuku == 1) 
                    this.statusBuku = 0;
                return false;
            }
            
            peminjaman.kodeBuku = this.kodeBuku;
            
            boolean ret = peminjaman.insert();
            
            if(ret){
                Database.commit();
            }else{
                if(this.statusBuku == 1) 
                    this.statusBuku = 0;
                Database.rollback();
            }
            return ret;
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
            boolean ret = pstmt.executeUpdate() > 0;
            if(ret){
                this.statusBuku = 1;
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
    
    public boolean update(){
        if(statusBuku == null){
            return false;
        }
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "UPDATE buku SET judul_buku = ?,  penulis_buku = ?  WHERE kode_buku = ?"
            );

            pstmt.setString(1, judulBuku);
            pstmt.setString(2, penulisBuku);
            pstmt.setString(3, kodeBuku);
            boolean ret = pstmt.executeUpdate() > 0;
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
    
    public boolean delete(){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "DELETE FROM buku WHERE kode_buku = ?"              
            );

            pstmt.setString(1, kodeBuku);
            boolean ret = pstmt.executeUpdate() > 0;
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
    
    public String getStatusString(){
        if (statusBuku == 0) return "Tersedia";
        else if (statusBuku == 1) return "Dipinjam";
        else return "";
    }
    
    public Object[] toArrayDaftar(){
        return new Object[]{
            kodeBuku,
            judulBuku,
            penulisBuku,
            getStatusString()
        };
    }
}
