/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.driversql;
import static java.lang.System.out;
import java.sql.*;

/**
 *
 * @author qukaj
 */
public class esempioDB {

    /**
     * @param args the command line arguments
     */
 public static void main(String[] args){
        persona p = new persona();
        System.setProperty("jdbc.drivers", "sun.jdbc.odbc.JdbcOdbcDriver");
        
        String URL_miodb = "jdbc:mysql://localhost:3306/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String query = "SELECT nome, cognome FROM bd;";
        Connection connessione = null;
     System.out.println("Connessione con: " + URL_miodb);
     try{
        connessione = DriverManager.getConnection(URL_miodb, "root", "albania02");
     }catch(Exception e){
         System.out.println("Errore : " + e);
         System.exit(1);
     }
     
     try{
         Statement state = connessione.createStatement();
         ResultSet resultSet = state.executeQuery(query);
         System.out.println(resultSet);
       while (resultSet.next()) {
             for (int i = 1; i <= 2; i++){
                 System.out.println(resultSet.getString(i));
             }
         }
     }catch(Exception e){
         System.out.println("Errore nella connessione: " + e);
         System.exit(1);
     }
     finally{
         if(connessione != null){
             try{
                 connessione.close();
             }catch(Exception e){
                 System.out.println("Errore nella chiusura della connessione");
             }
         }
     }
    
    }
}
