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
public class PreparedStatement implements AutoCloseable {

    Database parent;
    java.sql.PreparedStatement statement;
    
    PreparedStatement(Database parent, java.sql.PreparedStatement statement){
        this.statement = statement;
        this.parent = parent;
    }
    
    public void setNull(int index, int type){
        try{
            statement.setNull(index, type);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public int getUpdateCount(){
        try{
            return statement.getUpdateCount();
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public boolean execute(){
        try{
            return statement.execute();
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public ResultSet getResultSet(){
        try{
            return new ResultSet(this, statement.getResultSet());
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public ResultSet getGeneratedKeys(){
        try{
            return new ResultSet(this, statement.getGeneratedKeys());
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
    
    public void setString(int parameterIndex, String x){
        try{
            if(x == null) statement.setNull(parameterIndex, java.sql.Types.VARCHAR);
            else statement.setString(parameterIndex, x);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }
    public void setBoolean(int parameterIndex, Boolean x){
        try{
            if(x == null) statement.setNull(parameterIndex, java.sql.Types.BOOLEAN);
            else statement.setBoolean(parameterIndex, x);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }
    
    public void setInt(int parameterIndex, Integer x){
        try{
            if(x == null) statement.setNull(parameterIndex, java.sql.Types.INTEGER);
            else statement.setInt(parameterIndex, x);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }
    
    public void setLong(int parameterIndex, Long x){
        try{
            if(x == null) statement.setNull(parameterIndex, java.sql.Types.BIGINT);
            else statement.setLong(parameterIndex, x);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }
    
    
    public void setFloat(int parameterIndex, Float x){
        try{
            if(x == null) statement.setNull(parameterIndex, java.sql.Types.FLOAT);
            else statement.setFloat(parameterIndex, x);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }
    
    public void setDouble(int parameterIndex, Double x){
        try{
            if(x == null) statement.setNull(parameterIndex, java.sql.Types.DOUBLE);
            else statement.setDouble(parameterIndex, x);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }
    
    public void setTime(int parameterIndex, java.sql.Time x){
        try{
            if(x == null) statement.setNull(parameterIndex, java.sql.Types.TIME);
            else statement.setTime(parameterIndex, x);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }
    public void setTime(int parameterIndex, java.sql.Time x, java.util.Calendar cal){
        try{
            if(x == null) statement.setNull(parameterIndex, java.sql.Types.TIME);
            else statement.setTime(parameterIndex, x, cal);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }
    
    public void setDateTime(int parameterIndex, java.sql.Timestamp x){
        try{
            if(x == null) statement.setNull(parameterIndex, java.sql.Types.TIMESTAMP);
            else statement.setTimestamp(parameterIndex, x);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }
    public void setDateTime(int parameterIndex, java.sql.Timestamp x, java.util.Calendar cal){
        try{
            if(x == null) statement.setNull(parameterIndex, java.sql.Types.TIMESTAMP);
            else statement.setTimestamp(parameterIndex, x, cal);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }
    
    public void setDate(int parameterIndex, java.sql.Date x){
        try{
            if(x == null) statement.setNull(parameterIndex, java.sql.Types.DATE);
            else statement.setDate(parameterIndex, x);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }
    public void setDate(int parameterIndex, java.sql.Date x, java.util.Calendar c){
        try{
            if(x == null) statement.setNull(parameterIndex, java.sql.Types.DATE);
            else statement.setDate(parameterIndex, x, c);
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }finally{
            parent.close();
        }
    }

    public ResultSet executeQuery() {
        try{
            return new ResultSet(this, statement.executeQuery());
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    

    public int executeUpdate() {
        try{
            return statement.executeUpdate();
        }catch(java.sql.SQLException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
    
}
