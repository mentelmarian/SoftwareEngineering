/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restservermatchws;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.Connection;


/**
 *
 * @author sellere
 */
@Path("/matches")
@Produces("text/xml")
public class MatchRepository {
    
    
    private Map<Integer, Match> matches = new HashMap<>();

    {
        Seller seller1 = new Seller();
        Seller seller2 = new Seller();
        seller1.setId(1);
        seller1.setName("Seller A");
        seller1.setPrice(45);
        seller2.setId(2);
        seller2.setName("Seller B");
        seller2.setPrice(40);

        List<Seller> match1Sellers = new ArrayList<>();
        match1Sellers.add(seller1);
        match1Sellers.add(seller2);
        
        List<Seller> match2Sellers = new ArrayList<>();
        match2Sellers.add(seller1);
        
        Match match1 = new Match();
        Match match2 = new Match();
        
        match1.setId(1);
        match1.setDate("15/09/1996");
        match1.setHome("Lazio");
        match1.setVisitor("Roma");
        match1.setResult("2-1");
        match1.setSellers(match1Sellers);
        
        match2.setId(2);
        match2.setDate("15/09/1985");
        match2.setHome("Juve");
        match2.setVisitor("Inter");
        match2.setResult("6-1");
        match2.setSellers(match2Sellers);
        

        matches.put(1, match1);
        matches.put(2, match2);
    }
    
    
    @GET
    @Path("{matchId}")
    public Match getMatch(@PathParam("matchId") int matchId) {
        return findById(matchId);
    }
    

    
    @Path("{matchId}/sellers")
    public Match pathToSeller(@PathParam("matchId") int matchId) {
        return findById(matchId);
    }
    
    private Match findById(int id) {
        
        for (Map.Entry<Integer, Match> match : matches.entrySet()) {
            if (match.getKey() == id) {
                return match.getValue();
            }
        }
        return null;
        
    }

    
}
