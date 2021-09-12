/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restclluglio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.soapservluglio.Seller;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author studente
 */
public class Client {
    private static final String BASE_URL = "http://localhost:8080/";
    private static final String BASE_URL_T = "http://localhost:8090/";
    private static CloseableHttpClient client;

    public static void main(String[] args) throws IOException{
        client = HttpClients.createDefault();

        // Example GET
        System.out.println("La lista dei match: ");
        Match match = getMatch(1);
        System.out.println(match);
        match = getMatch(2);
        System.out.println(match);
        match = getMatch(3);
        System.out.println(match);
        match = getMatch(4);
        System.out.println(match);

        //dettagli match e team dato ID match
        System.out.println("Inserisci id del match per i dettagli: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        sc.close();
        getDettagli(Integer.parseInt(input));

        //trascinato dopo aver fatto web service client   
        try { // Call Web Service Operation
            com.mycompany.soapservluglio.ExamImplService service = new com.mycompany.soapservluglio.ExamImplService();
            com.mycompany.soapservluglio.Exam port = service.getExamImplPort();
            // TODO initialize WS operation arguments here
            int arg0 = Integer.parseInt(input);
            // TODO process result here
            com.mycompany.soapservluglio.Ticket result = port.getTicket(arg0);
            if (result == null) System.out.println("Non ci sono seller per questo match!");
            System.out.println("Per il match con id = "+result.getMatchId() + " il costo del biglietto è: " + result.getPrice() );
            List<Seller> sellers = result.getSellers();
            Iterator<Seller> iterator = sellers.iterator();
            while(iterator.hasNext()){
                Seller s = iterator.next();
                System.out.println("I seller per il match con id "+arg0+" sono: ");
                System.out.println(s.getName() + " con data stimata di arrivo " + s.getDate());
            }
        } catch (Exception ex) {
        // TODO handle custom exceptions here
        }
    
    
       client.close();
        
    }



    private static Match getMatch(int id) throws IOException {
        
        // JSON Marshaling
        ObjectMapper mapper = new ObjectMapper();
        final URL url = new URL(BASE_URL + "matches/" + id);
        InputStream input = url.openStream();
        Match mt = (Match)mapper.readValue(input, Match.class);        
        return mt;
    }
    

    private static Team getTeam(int id) throws IOException {
        
        // JSON Marshaling
        ObjectMapper mapper = new ObjectMapper();
        final URL url = new URL(BASE_URL_T + "teams/" + id);
        InputStream input = url.openStream();
        Team mt = (Team)mapper.readValue(input, Team.class);        
        return mt;
    }
    
    private static void getDettagli(int id) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        final URL url = new URL(BASE_URL + "matches/" + id);
        InputStream input = url.openStream();
        Match mt = (Match)mapper.readValue(input, Match.class);
        System.out.println(mt);
        Team t = getTeam(mt.getTeamId());
        System.out.println(t);
        Team t2 = getTeam(mt.getVisitorId());
        System.out.println(t2);
    }


}
