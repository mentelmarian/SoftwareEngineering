/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restservlugliot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author studente
 */
@Path("/teams")
public class TeamRepository {
    private Connection conn;
    
    public void setConnection(String pos) {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TeamRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn
                    = DriverManager.getConnection("jdbc:sqlite:" + pos);
        } catch (SQLException ex) {
            Logger.getLogger(TeamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{teamID}")
    @Produces("application/json")
    public Team getTeam(@PathParam("teamID") int teamID) {

        return findTeamById(teamID);
    }


    private Team findTeamById(int id) {

        PreparedStatement stat = null;
        Team mt = null;
        try {
            stat = conn.prepareStatement("select * from teams where teamID = ?");
            stat.setString(1, String.valueOf(id));

            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                mt = new Team();
                mt.setTeamID(Integer.parseInt(rs.getString("teamID")));
                mt.setName(rs.getString("name"));
                mt.setCoach(rs.getString("coach"));
                Logger.getLogger(TeamRepository.class.getName()).log(Level.INFO, "Accessed : " + mt);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mt;
    }
}
