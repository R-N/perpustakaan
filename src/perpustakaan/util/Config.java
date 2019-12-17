/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.util;

import java.util.Locale;
import java.sql.SQLException;
import perpustakaan.util.database.Database;
import perpustakaan.util.database.PreparedStatement;
import perpustakaan.util.database.ResultSet;

/**
 *
 * @author MojoMacW7
 */
public class Config {
    public static boolean indoComma = false;
    
    public static void init() {
        boolean ret = Database.execute("CREATE TABLE IF NOT EXISTS Config(name TEXT PRIMARY KEY, value TEXT)");
        ret = ret && Database.commit();
        defaultIndoComma();
    }
    
    public static void defaultIndoComma() {
        String sIndoComma = get("indoComma");
        if(sIndoComma == null || sIndoComma.trim().isEmpty()){
            setIndoComma(Locale.getDefault().equals(Util.idLocale));
        }else{
            setIndoComma(sIndoComma);
        }
    }
    public static void setIndoComma(String sIndoComma){
        if(sIndoComma == null || sIndoComma.trim().isEmpty()){
            return;
        }
        setIndoComma(Boolean.valueOf(sIndoComma));
    }
    public static void setIndoComma(boolean indoComma) {
        Config.indoComma = indoComma;
        Config.save("indoComma", String.valueOf(indoComma));
    }
    
    public static boolean saveIfNotExists(String name, String value) {
        PreparedStatement pstmt = Database.prepareStatement("INSERT OR IGNORE INTO Config(name, value) VALUES(?, ?)");
        pstmt.setString(1, name);
        pstmt.setString(2, value);
        int rows = pstmt.executeUpdate();
        if(Database.commit()){
            return rows>0;
        }
        return false;
    }
    public static boolean save(String name, String value) {
        PreparedStatement pstmt = Database.prepareStatement("UPDATE Config SET value=? WHERE name=?");
        pstmt.setString(2, name);
        pstmt.setString(1, value);
        int ret = pstmt.executeUpdate();
        if(ret>0){
            return Database.commit();
        }
        return false;
    }
    public static String get(String name) {
        PreparedStatement pstmt =Database.prepareStatement("SELECT value FROM Config WHERE name=?");
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()){
            return rs.getString(1);
        }
        return null;
    }
}
