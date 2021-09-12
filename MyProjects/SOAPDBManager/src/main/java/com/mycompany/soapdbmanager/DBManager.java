/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapdbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author studente
 */
public class DBManager {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try {
            
            //CHANGE WITH THE PATH INWHICH YOU CREATE THE DB
            
            connection = DriverManager.getConnection("jdbc:sqlite:/home/studente/SOAPdb.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("DROP TABLE IF EXISTS STUDENTS;");
            statement.executeUpdate("CREATE TABLE STUDENTS (ID INTEGER PRIMARY KEY, "
                                    + "name STRING, "
                                    + "yearOfBirth STRING);");
        
            
            statement.executeUpdate("INSERT INTO STUDENTS VALUES(0, 'Kathryn Bigelow', '1951');");
         
            statement.executeUpdate("INSERT INTO STUDENTS VALUES(1, 'Neill Blomkamp', '1979');");
  
            
            statement.executeUpdate("INSERT INTO STUDENTS VALUES(2, 'Jason Reitman', '1977');");
            
            statement.executeUpdate("INSERT INTO STUDENTS VALUES(3, 'Quentin Tarantino', '1963');");
            
            ResultSet rs1 = statement.executeQuery("SELECT * FROM STUDENTS");
            while (rs1.next()) {
                System.out.println("Student " + rs1.getInt("ID")
                                   + " is " + rs1.getString("name")
                                   + " and was born in " + rs1.getString("yearOfBirth"));
            }
            
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
