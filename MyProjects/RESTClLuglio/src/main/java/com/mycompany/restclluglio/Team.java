/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restclluglio;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author studente
 */
@XmlRootElement(name = "Team")
public class Team {
    private int teamID;
    private String name;
    private String coach;

    public Team() {
    }

    public Team(int teamID, String name, String coach) {
        this.teamID = teamID;
        this.name = name;
        this.coach = coach;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.teamID;
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
        final Team other = (Team) obj;
        if (this.teamID != other.teamID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Team{" + "teamID=" + teamID + ", name=" + name + ", coach=" + coach + '}';
    }
}
