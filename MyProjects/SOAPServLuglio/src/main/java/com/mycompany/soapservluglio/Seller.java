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
public class Seller {
    private String date;
    private String name;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Seller() {
    }

    public Seller(String date, String name) {
        this.date = date;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Seller{" + "date=" + date + ", name=" + name + '}';
    }
    
    
}
