/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restservermatchws;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sellere
 */

@XmlRootElement(name = "Match")
public class Match {
    
    private int id;
    private String date;
    private String home;
    private String visitor;
    private String result;
    private List<Seller> sellers = new ArrayList<>();

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    
    @GET
    @Path("{sellerId}")
    public Seller getSeller(@PathParam("sellerId") int sellerId) {
        return findById(sellerId);
    }

    @POST
    public Response createSeller(Seller seller) {
        for (Seller element : sellers) {
            if (element.getId() == seller.getId()) {
                return Response.status(Response.Status.CONFLICT).build();
            }
        }
        sellers.add(seller);
        return Response.ok(seller).build();
    }

    @DELETE
    @Path("{sellerId}")
    public Response deleteSeller(@PathParam("sellerId") int sellerId) {
        Seller seller = findById(sellerId);
        if (seller == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        sellers.remove(seller);
        return Response.ok().build();
    }

    private Seller findById(int id) {
        for (Seller seller : sellers) {
            if (seller.getId() == id) {
                return seller;
            }
        }
        return null;
    }
    
    
    @Override
    public int hashCode() {
        return id + date.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Match) && (id == ((Match) obj).getId()) && (date.equals(((Match) obj).getDate()));
    }
    
}
