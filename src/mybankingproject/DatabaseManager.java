/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybankingproject;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MWIGO-JON-MARK
 */
public class DatabaseManager
{
    static Connection conn = null;
    static Statement statement;
    static String uri = "jdbc:sqlite::memory:";
    static String driverName = "org.sqlite.JDBC";
    static ResultSet rs;
    public static void dbConnect(){
        try{
//            String uri = "jdbc:sqlite:C:/sqlite/dbTry1.db";
            
            Class.forName(driverName);
            conn = DriverManager.getConnection(uri);
            System.out.println("Sqlite DB Connected");
        } catch(SQLException ex1){
            System.out.println(ex1.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try{
                if(conn != null){
                    conn.close();
                }
            } catch(SQLException ex2){
                System.out.println(ex2.getMessage());
            }
        }
        
//        Database db = new SQLite.Database();
//        try{
//            db.open(":memory:", 700);
//            
//            System.out.println("Sqlite DB Connected");
////            db.trace(new SQLTrace());
////            query.(db);
//            db.close();
//        } catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
    }
    
    public static void dbCreate(){
        
//        String uri = "jdbc:sqlite::memory:";
        try{
            Class.forName(driverName);
            conn = DriverManager.getConnection(uri);
//            statement = conn.createStatement();
            if(conn != null){
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Driver: " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch(SQLException ex){
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        } finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
        }
    }
    public static void dbTableCreate(){
        //Can't create db, returns "Null" into Logger.
        try{
            Class.forName(driverName);
            conn = DriverManager.getConnection(uri);
            statement = conn.createStatement();
            String query = "CREATE TABLE clients "
                    + "(ID INT AS (6657667865412232) PRIMARY KEY      NOT NULL,"
                    + "First Name TEXT          NOT NULL,"
                    + "Last Name TEXT           NOT NULL,"
                    + "Age INT                  NOT NULL,"
                    + "Nationality TEXT         NOT NULL,"
                    + "Marital Status TEXT      NOT NULL,"
                    + "Sex TEXT                 NOT NULL"
                    + "Telephone INT            NOT NULL,"
                    + "Address TEXT             NOT NULL,"
                    + "Residence TEXT           NOT NULL,"
                    + "Date Of Birth DATE       NOT NULL)";
            statement.executeUpdate(query);
        } catch(SQLException ex){
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        } finally{
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
        }
    }
    
    public static void dbInsertData(String tableName, String fName, String lName, 
            String nationality, String married, String sex, String address, 
            String residence, String dateOfBirth, int phoneNo){
        
        //Can't insert into db, returns "Null" into Logger.
        try{
            Class.forName(driverName);
            conn = DriverManager.getConnection(uri);
            statement = conn.createStatement();
            String query = "INSERT INTO " + tableName +
                    " (" +
                    fName + "," + lName + "," + nationality + ","
                    + married + "," + sex + "," + phoneNo + "," + address + "," + residence + "," + dateOfBirth + ");";
            statement.executeUpdate(query);
        } catch(SQLException ex){
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        } finally{
            try {
                statement.close();
                conn.commit();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
        }
    }
    
    public static Map dbGetData(String tableName, String content){
        try{
            Class.forName(driverName);
            conn = DriverManager.getConnection(uri);
            conn.setAutoCommit(false);
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT "+ content +" FROM " + tableName);
            while(rs.next()){
                int age = rs.getInt("Age");
                int telephone = rs.getInt("Telephone");
                
                String ageString = Integer.toString(age);
                String telephoneString = Integer.toString(telephone);
                
                String fName = rs.getString("First Name");
                String lName = rs.getString("Last Name");
                String nationality = rs.getString("Nationality");
                String maritalStatus = rs.getString("Marital Status");
                String sex = rs.getString("Sex");
                String address = rs.getString("Address");
                String residence = rs.getString("Residence");
                String dateOfBirth = rs.getString( "Date Of Birth");
                
                Map<String, String> dbValues = new HashMap<String, String>();
                dbValues.put("age", ageString);
                dbValues.put("telephone", telephoneString);
                dbValues.put("fName", fName);
                dbValues.put("lName", lName);
                dbValues.put("nationality", nationality);
                dbValues.put("maritalStatus", maritalStatus);
                dbValues.put("sex", sex);
                dbValues.put("address", address);
                dbValues.put("residence", residence);
                dbValues.put("dateOfBirth", dateOfBirth);
                return dbValues;
            }
        } catch(SQLException ex){
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                statement.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}
