/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restservdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.*;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author studente
 */
@Path("/students")
public class StudentRepository {
    private Connection conn;
    
    public void setConnection(String pos) {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudentRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn
                    = DriverManager.getConnection("jdbc:sqlite:" + pos);
        } catch (SQLException ex) {
            Logger.getLogger(StudentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{studentId}")
    @Produces("application/json")
    public Student getStudent(@PathParam("studentId") int studentId) {

        return findStudentById(studentId);
    }

    @PUT
    @Path("{studentId}")
    @Consumes("application/json")
    public Response updateStudent(@PathParam("studentId") int studentId, Student student) {
        Student existing = findStudentById(studentId);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if (existing.equals(student)) {
            return Response.notModified().build();
        }
        update(studentId, student);
        return Response.ok().build();
    }

    private Student findStudentById(int id) {

        PreparedStatement stat = null;
        Student st = null;
        try {
            stat = conn.prepareStatement("select * from student where id = ?");
            stat.setString(1, String.valueOf(id));

            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                st = new Student();
                st.setId(Integer.parseInt(rs.getString("id")));
                st.setNome(rs.getString("nome"));
                st.setCognome(rs.getString("cognome"));
                Logger.getLogger(StudentRepository.class.getName()).log(Level.INFO, "Accessed : " + st);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return st;
    }

    private void update(int studentId, Student student) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement("update student set nome = ? where id = ?");
            stat.setString(1, student.getNome());
            stat.setString(2, String.valueOf(studentId));

            int affectedRow = stat.executeUpdate();
            if (affectedRow == 1) {
                Logger.getLogger(StudentRepository.class.getName()).log(Level.INFO, "Updated : " + student);
                return;
            } else {
                throw new RuntimeException();
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
