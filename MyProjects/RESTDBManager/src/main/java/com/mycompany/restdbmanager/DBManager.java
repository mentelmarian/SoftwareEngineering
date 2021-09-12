/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restdbmanager;


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

        if (args.length > 1 && args[1].equals("create")) {
            stat.executeUpdate("drop table if exists student;");
            stat.executeUpdate("create table student (id, nome, cognome);");
            PreparedStatement prep = conn.prepareStatement(
                    "insert into student values (?, ?, ?);");
            prep.setString(1, "151");
            prep.setString(2, "Marian");
            prep.setString(3, "Mentel");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "3878");
            prep.setString(2, "Elisa");
            prep.setString(3, "Berti");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "3873");
            prep.setString(2, "Francesc");
            prep.setString(3, "Schettino");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
            
            prep.setString(1, "4837");
            prep.setString(2, "Nich");
            prep.setString(3, "Marasco");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();
            conn.setAutoCommit(true);
        
            
            System.out.println("Created Database\n");
        } else {
            System.out.println("STUDENTS\n");
            
            ResultSet rs1 = stat.executeQuery("select * from student;");
            while (rs1.next()) {
                System.out.print("Student = " + rs1.getString("id") + " is : ");
                System.out.println(rs1.getString("nome") + " cognome: " + rs1.getString("cognome"));

            }
            rs1.close();
        }
        conn.close();
    }
}
