/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbmanager;
import java.sql.*;
/**
 *
 * @author studente
 */
public class DBManager {
     public static void main(String[] args) throws Exception {

        Class.forName("org.sqlite.JDBC");
        Connection conn
                = DriverManager.getConnection("jdbc:sqlite:"+args[0]);
        Statement stat = conn.createStatement();

      
        stat.executeUpdate("drop table if exists vaccinations;");
        stat.executeUpdate("create table vaccinations (ID, personID, date, type);");
         PreparedStatement prep = conn.prepareStatement(
                 "insert into vaccinations values (?, ?, ?, ?);");
         
         prep.setString(1, "1");
         prep.setString(2, "FFCRFFCFC");
         prep.setString(3, "20/03/2021");
         prep.setString(4, "Pfizer");
         prep.addBatch();
         conn.setAutoCommit(false);
         prep.executeBatch();
         conn.setAutoCommit(true);

         prep.setString(1, "2");
         prep.setString(2, "HDHFFHEDF");
         prep.setString(3, "20/03/2021");
         prep.setString(4, "Pfizer");
         prep.addBatch();
         conn.setAutoCommit(false);
         prep.executeBatch();
         conn.setAutoCommit(true);
         
         prep.setString(1, "3");
         prep.setString(2, "HDSJFHNUEH");
         prep.setString(3, "20/03/2021");
         prep.setString(4, "Pfizer");
         prep.addBatch();
         conn.setAutoCommit(false);
         prep.executeBatch();
         conn.setAutoCommit(true);
         
         prep.setString(1, "4");
         prep.setString(2, "LAFIDEFNI");
         prep.setString(3, "20/03/2021");
         prep.setString(4, "Pfizer");
         prep.addBatch();
         conn.setAutoCommit(false);
         prep.executeBatch();
         conn.setAutoCommit(true);
         
         prep.setString(1, "5");
         prep.setString(2, "EJAFFGGIEJ");
         prep.setString(3, "20/03/2021");
         prep.setString(4, "Moderna");
         prep.addBatch();
         conn.setAutoCommit(false);
         prep.executeBatch();
         conn.setAutoCommit(true);
        
         prep.setString(1, "6");
         prep.setString(2, "SDHUHFIREU");
         prep.setString(3, "20/03/2021");
         prep.setString(4, "Moderna");
         prep.addBatch();
         conn.setAutoCommit(false);
         prep.executeBatch();
         conn.setAutoCommit(true);
         
         prep.setString(1, "7");
         prep.setString(2, "ASKJHFE");
         prep.setString(3, "20/03/2021");
         prep.setString(4, "Moderna");
         prep.addBatch();
         conn.setAutoCommit(false);
         prep.executeBatch();
         conn.setAutoCommit(true);
         
         prep.setString(1, "8");
         prep.setString(2, "WKWOFIHMK,");
         prep.setString(3, "20/03/2021");
         prep.setString(4, "Moderna");
         prep.addBatch();
         conn.setAutoCommit(false);
         prep.executeBatch();
         conn.setAutoCommit(true);
         
         prep.setString(1, "9");
         prep.setString(2, "LDIKSWIFDE");
         prep.setString(3, "20/03/2021");
         prep.setString(4, "Johnson");
         prep.addBatch();
         conn.setAutoCommit(false);
         prep.executeBatch();
         conn.setAutoCommit(true);
         
         prep.setString(1, "10");
         prep.setString(2, "PKOJFIEN");
         prep.setString(3, "20/03/2021");
         prep.setString(4, "Johnson");
         prep.addBatch();
         conn.setAutoCommit(false);
         prep.executeBatch();
         conn.setAutoCommit(true);
         
         
         
         


         System.out.println("Created Database\n");
         
         System.out.println("Vaccinations\n");
            
            ResultSet rs1 = stat.executeQuery("select * from vaccinations;");
            while (rs1.next()) {
                System.out.print("Vaccination " + rs1.getString("ID") + " to ");
                System.out.println(rs1.getString("personID") + " in date: " + rs1.getString("date") + " of type " + rs1.getString("type") );

            }
            rs1.close();
        
        conn.close();
    }
}
