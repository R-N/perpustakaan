/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.util.database;

/**
 *
 * @author Lenovo2
 */
public class ResultSet implements AutoCloseable {
    PreparedStatement parent;
    java.sql.ResultSet rs;
    
    ResultSet(PreparedStatement parent, java.sql.ResultSet rs){
        this.parent = parent;
        this.rs = rs;
    }
    
    public boolean next(){
        try{
            return rs.next();
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public boolean isNull(int index){
        try{
            return rs.getObject(index) == null;
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public boolean isNull(String name){
        try{
            return rs.getObject(name) == null;
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public Integer getInt(int index){
        try{
            if(isNull(index)) return null;
            else return rs.getInt(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public Integer getInt(String name){
        try{
            if(isNull(name)) return null;
            else return rs.getInt(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    
    public Long getLong(int index){
        try{
            if(isNull(index)) return null;
            else return rs.getLong(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    
    public Long getLong(String name){
        try{
            if(isNull(name)) return null;
            else return rs.getLong(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    
    public String getString(int index){
        try{
            if(isNull(index)) return null;
            else return rs.getString(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public String getString(String name){
        try{
            if(isNull(name)) return null;
            else return rs.getString(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public Boolean getBoolean(int index){
        try{
            if(isNull(index)) return null;
            else return rs.getBoolean(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public Boolean getBoolean(String name){
        try{
            if(isNull(name)) return null;
            else return rs.getBoolean(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public java.sql.Date getDate(int index){
        try{
            if(isNull(index)) return null;
            else return rs.getDate(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public java.sql.Date getDate(String name){
        try{
            if(isNull(name)) return null;
            else return rs.getDate(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public java.sql.Time getTime(int index){
        try{
            if(isNull(index)) return null;
            else return rs.getTime(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public java.sql.Time getTime(String name){
        try{
            if(isNull(name)) return null;
            else return rs.getTime(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public java.sql.Timestamp getDateTime(int index){
        try{
            if(isNull(index)) return null;
            else return rs.getTimestamp(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public java.sql.Timestamp getDateTime(String name){
        try{
            if(isNull(name)) return null;
            else return rs.getTimestamp(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public void close(){
        try{
            rs.close();
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            //parent.close();
        }
    }
}
