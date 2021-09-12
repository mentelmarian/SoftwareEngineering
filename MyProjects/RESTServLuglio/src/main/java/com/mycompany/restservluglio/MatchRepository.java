/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restservluglio;

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
@Path("/matches")
public class MatchRepository {
    private Connection conn;
    
    public void setConnection(String pos) {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MatchRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn
                    = DriverManager.getConnection("jdbc:sqlite:" + pos);
        } catch (SQLException ex) {
            Logger.getLogger(MatchRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{matchID}")
    @Produces("application/json")
    public Match getMatch(@PathParam("matchID") int matchID) {

        return findMatchById(matchID);
    }


    private Match findMatchById(int id) {

        PreparedStatement stat = null;
        Match mt = null;
        try {
            stat = conn.prepareStatement("select * from matches where id = ?");
            stat.setString(1, String.valueOf(id));

            ResultSet rs = stat.executeQuery();
            if (rs.next()) {
                mt = new Match();
                mt.setID(Integer.parseInt(rs.getString("id")));
                mt.setDate(rs.getString("date"));
                mt.setResult(rs.getString("result"));
                mt.setTeamId(Integer.parseInt(rs.getString("homeId")));
                mt.setVisitorId(Integer.parseInt(rs.getString("visitorId")));
                Logger.getLogger(MatchRepository.class.getName()).log(Level.INFO, "Accessed : " + mt);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MatchRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return mt;
    }

}
