/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personsserv;

import javax.xml.ws.Endpoint;

/**
 *
 * @author studente
 */

public class Server {
    public static void main(String args[]) throws InterruptedException {
        ExamImpl implementor = new ExamImpl();
        String address = "http://localhost:8070/Exam";
        
        
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        p1.setPersonID("FFCRFFCFC");
        p1.setName("Ciro");
        p1.setSurname("ci");
        p1.setBirth("12/04/1998");
        p1.setResidence("Rome");
        
        p2.setPersonID("HDHFFHEDF");
        p2.setName("Valeria");
        p2.setSurname("Lungo");
        p2.setBirth("12/04/1998");
        p2.setResidence("Rome");
        
        p3.setPersonID("HDSJFHNUEH");
        p3.setName("Claudia");
        p3.setSurname("Mari");
        p3.setBirth("12/04/1998");
        p3.setResidence("Rome");
      
        
        ExamImpl.persons.put(1, p1);
        ExamImpl.persons.put(2, p2);
        ExamImpl.persons.put(3, p3);
        
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
        while(true) {}
        //Thread.sleep(60 * 1000);
        //System.exit(0);
    }
}
