/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personsserv;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author studente
 */
@XmlRootElement
public class Person {
    private String personID;
    private String name;
    private String surname;
    private String birth;
    private String residence;

    public Person() {
    }

    public Person(String personID, String name, String surname, String birth, String residence) {
        this.personID = personID;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.residence = residence;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    @Override
    public String toString() {
        return "Person{" + "personID=" + personID + ", name=" + name + ", surname=" + surname + ", birth=" + birth + ", residence=" + residence + '}';
    }
    
    
}
