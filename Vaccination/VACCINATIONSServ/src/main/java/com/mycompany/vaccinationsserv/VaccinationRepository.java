/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vaccinationsserv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author studente
 */
@Path("/vaccinations")
public class VaccinationRepository {
    private Connection conn;
    
    public void setConnection(String pos) {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VaccinationRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn
                    = DriverManager.getConnection("jdbc:sqlite:" + pos);
        } catch (SQLException ex) {
            Logger.getLogger(VaccinationRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{ID}")
    @Produces("application/json")
    public Vaccination getVaccination(@PathParam("ID") String ID) {

        return findVaccinationById(ID);
    }


    private Vaccination findVaccinationById(String id) {

        PreparedStatement stat = null;
        Vaccination v = null;
        try {
            stat = conn.prepareStatement("select * from vaccinations where id = ?");
            stat.setString(1, String.valueOf(id));

            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                v = new Vaccination();
                v.setID(rs.getString("id"));
                v.setPersonID(rs.getString("personID"));
                v.setDate(rs.getString("date"));
                v.setType(rs.getString("type"));
                Logger.getLogger(VaccinationRepository.class.getName()).log(Level.INFO, "Accessed : " + v);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(VaccinationRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return v;
    }
}
