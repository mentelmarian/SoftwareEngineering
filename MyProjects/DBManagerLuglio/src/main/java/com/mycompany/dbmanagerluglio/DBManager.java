/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbmanagerluglio;

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
            
            connection = DriverManager.getConnection("jdbc:sqlite:/home/studente/luglio.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("DROP TABLE IF EXISTS MATCHES;");
            statement.executeUpdate("DROP TABLE IF EXISTS TEAMS;");
            
            statement.executeUpdate("CREATE TABLE TEAMS(teamID INTEGER PRIMARY KEY AUTOINCREMENT, "
                                    + "name STRING, "
                                    + "coach STRING );");
            
            statement.executeUpdate("CREATE TABLE MATCHES (ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                                    + "date STRING, "
                                    + "result STRING,"
                                    + "homeId STRING,"
                                    + "visitorId STRING,"
                                    + "FOREIGN KEY(homeId) REFERENCES TEAMS(teamID)"
                                    + "FOREIGN KEY(visitorId) REFERENCES TEAMS(teamID));");
                       
            
            statement.executeUpdate("INSERT INTO TEAMS VALUES(0, 'Roma', 'Spalletti');");
            statement.executeUpdate("INSERT INTO TEAMS VALUES(1, 'Lazio', 'Inzaghi');");
            statement.executeUpdate("INSERT INTO TEAMS VALUES(2, 'Inter', 'Conte');");
            statement.executeUpdate("INSERT INTO TEAMS VALUES(3, 'Juve', 'Allegri');");
            
            statement.executeUpdate("INSERT INTO MATCHES(date, result, homeId, visitorId) VALUES('1990', '2-1', 0, 1);");
            statement.executeUpdate("INSERT INTO MATCHES(date, result, homeId, visitorId) VALUES('2010', '3-1', 1, 2);");
            statement.executeUpdate("INSERT INTO MATCHES(date, result, homeId, visitorId) VALUES('2020', '1-1', 2, 3);");
            statement.executeUpdate("INSERT INTO MATCHES(date, result, homeId, visitorId) VALUES('2020', '3-1', 3, 4);");
            
            
            ResultSet rs1 = statement.executeQuery("SELECT * FROM TEAMS");
            while (rs1.next()) {
                System.out.println("Team " + rs1.getInt("teamID")
                                   + " is " + rs1.getString("name")
                                   + " and coached by " + rs1.getString("coach"));
            }
            
            ResultSet rs2 = statement.executeQuery("SELECT * FROM MATCHES");
            while (rs2.next()) {
                System.out.println("Match " + rs2.getInt("ID")
                                   + " on " + rs2.getString("date") 
                                   + " got " + rs2.getString("result") 
                                   + " teams " + rs2.getInt("homeId")
                                   + " vs " + rs2.getInt("visitorId"));
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
