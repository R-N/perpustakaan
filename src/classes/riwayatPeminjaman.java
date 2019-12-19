/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.SQLException;
import perpustakaan.util.Util;
import perpustakaan.util.database.Database;

/**
 *
 * @author ARION
 */
public class riwayatPeminjaman {
    public Integer idPeminjaman;
        
    public boolean tampilPeminjaman(){
        try{
            java.sql.PreparedStatement pstmt = Database.prepareStatement(
                    "SELECT kode_buku, id_peminjaman, nama_peminjam, waktu_pinjam, waktu_kembali FROM peminjaman WHERE id_peminjaman = ?"
            );
            
            pstmt.setInt(1, idPeminjaman);
            return pstmt.execute();
        }catch(SQLException ex){
            Util.handleException(ex);
            return false;
        }
    }
}
