package com.mycompany.restclientmatchws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
@XmlRootElement(name = "Match")
public class Match {
    
    private int id;
    private String date;
    private String home;
    private String visitor;
    private String result;
    private List<Seller> sellers = new ArrayList<>();

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

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }
    
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Match) && (id == ((Match) obj).getId()) && (date.equals(((Match) obj).getDate()));
    }

    @Override
    public String toString() {
        return "Match{" + "id=" + id + ", date=" + date + ", home=" + home + ", visitor=" + visitor + ", result=" + result + ", sellers=" + sellers + '}';
    }
    
}
