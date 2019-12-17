/*
 * To change this license header, choose License Headestatement in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaan.util.database;

/**
 *
 * @author Lenovo2
 */
public class CallableStatement extends PreparedStatement{
    Database parent;
    java.sql.CallableStatement statement;
    
    CallableStatement(Database parent, java.sql.CallableStatement statement){
        super(parent, statement);
        this.parent = parent;
        this.statement = statement;
    }
    
    public void registerOutParameter(int index, java.sql.SQLType type){
        try{
            statement.registerOutParameter(index, type);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public void registerOutParameter(int index, int type){
        try{
            statement.registerOutParameter(index, type);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public void registerOutParameter(String name, java.sql.SQLType type){
        try{
            statement.registerOutParameter(name, type);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public void registerOutParameter(String name, int type){
        try{
            statement.registerOutParameter(name, type);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public void close() {
        try{
            statement.close();
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }
    
    public boolean isNull(int index){
        try{
            return statement.getObject(index) == null;
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public boolean isNull(String name){
        try{
            return statement.getObject(name) == null;
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public Integer getInt(int index){
        try{
            if(isNull(index)) return null;
            else return statement.getInt(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public Integer getInt(String name){
        try{
            if(isNull(name)) return null;
            else return statement.getInt(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    
    public Long getLong(int index){
        try{
            if(isNull(index)) return null;
            else return statement.getLong(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    
    public Long getLong(String name){
        try{
            if(isNull(name)) return null;
            else return statement.getLong(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    
    public String getString(int index){
        try{
            if(isNull(index)) return null;
            else return statement.getString(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public String getString(String name){
        try{
            if(isNull(name)) return null;
            else return statement.getString(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public Boolean getBoolean(int index){
        try{
            if(isNull(index)) return null;
            else return statement.getBoolean(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public Boolean getBoolean(String name){
        try{
            if(isNull(name)) return null;
            else return statement.getBoolean(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public java.sql.Date getDate(int index){
        try{
            if(isNull(index)) return null;
            else return statement.getDate(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public java.sql.Date getDate(String name){
        try{
            if(isNull(name)) return null;
            else return statement.getDate(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public java.sql.Time getTime(int index){
        try{
            if(isNull(index)) return null;
            else return statement.getTime(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public java.sql.Time getTime(String name){
        try{
            if(isNull(name)) return null;
            else return statement.getTime(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public java.sql.Timestamp getDateTime(int index){
        try{
            if(isNull(index)) return null;
            else return statement.getTimestamp(index);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    public java.sql.Timestamp getDateTime(String name){
        try{
            if(isNull(name)) return null;
            else return statement.getTimestamp(name);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
