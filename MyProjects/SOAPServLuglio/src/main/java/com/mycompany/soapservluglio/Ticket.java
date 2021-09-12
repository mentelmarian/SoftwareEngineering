/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservluglio;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author studente
 */
@XmlRootElement
public class Ticket {
    private int matchId;
    private float price;
    private List<Seller> sellers = new ArrayList<>();

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public Ticket() {
    }

    public Ticket(int matchId, float price) {
        this.matchId = matchId;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" + "matchId=" + matchId + ", price=" + price + ", sellers=" + sellers + '}';
    }
    
    
}
