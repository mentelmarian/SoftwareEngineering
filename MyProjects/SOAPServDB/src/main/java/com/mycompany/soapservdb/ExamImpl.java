/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.jws.WebService;

/**
 *
 * @author studente
 */
@WebService(endpointInterface = "com.mycompany.soapservdb.Exam")
public class ExamImpl implements Exam{
    private Connection connection = null;

    public ExamImpl() {
        try {
            Class.forName("org.sqlite.JDBC");
            
            // CAMBIA IL PATH DEL DB A SECONDA DI DOVE LO CREI
            
            connection = DriverManager.getConnection("jdbc:sqlite:/home/studente/SOAPdb.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    @Override
    public Student getStudent(int ID) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM STUDENTS WHERE ID = ?;");
            statement.setInt(1, ID);
            statement.setQueryTimeout(30);
            
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                return new Student(rs.getInt("ID"),
                                    rs.getString("name"),
                                    rs.getString("yearOfBirth"));
            }
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }

    
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
                System.err.println(e);
        }
    }
}
