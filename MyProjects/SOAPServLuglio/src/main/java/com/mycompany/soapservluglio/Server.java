/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservluglio;

import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.Endpoint;

/**
 *
 * @author studente
 */
public class Server {
    public static void main(String args[]) throws InterruptedException {
        ExamImpl implementor = new ExamImpl();
        String address = "http://localhost:8070/Exam";
        
        
        List<Seller> sellers = new ArrayList<>();
        Seller s1 = new Seller();
        Seller s2 = new Seller();
        s1.setDate("12-2-99");
        s1.setName("TicketOne");
        s2.setDate("12-2-96");
        s2.setName("Ciao");
        sellers.add(s2);
        sellers.add(s1);
        
        Ticket t1 = new Ticket();
        t1.setMatchId(1);
        t1.setPrice(15);
        t1.setSellers(sellers);
        
        ExamImpl.tickets.put(1, t1);
        
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
        while(true) {}
        //Thread.sleep(60 * 1000);
        //System.exit(0);
    }
}
