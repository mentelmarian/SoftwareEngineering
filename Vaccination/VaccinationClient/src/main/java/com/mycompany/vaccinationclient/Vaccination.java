/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vaccinationclient;

import java.util.Objects;

/**
 *
 * @author studente
 */
public class Vaccination {
    private String ID;
    private String personID;
    private String date;
    private String type;

    public Vaccination() {
    }

    public Vaccination(String ID, String personID, String date, String type) {
        this.ID = ID;
        this.personID = personID;
        this.date = date;
        this.type = type;
    }

    
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.ID);
        hash = 53 * hash + Objects.hashCode(this.personID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vaccination other = (Vaccination) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vaccination{" + "ID=" + ID + ", personID=" + personID + ", date=" + date + ", type=" + type + '}';
    }
}
