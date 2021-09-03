package com.mycompany.restclientmatchws;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import javax.xml.bind.JAXB;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
public class Client {
    
    private static final String BASE_URL = "http://localhost:8080/matches/";
    private static CloseableHttpClient client;
    private static String input = new String();
    private static String inputt = new String();
    
    public static void main(String[] args) throws IOException{
    client = HttpClients.createDefault();
    
   /*  Example GET
    Match match = getMatch(1);
    System.out.println(match);
    for (int i = 0; i < match.getSellers().size(); i++) {
        Seller seller = match.getSellers().get(i);
        System.out.println(seller);
    }
    
    // Example POST/PUT
    match = getMatch(2);
    System.out.println(match);
    for (int i = 0; i < match.getSellers().size(); i++) {
        Seller seller = match.getSellers().get(i);
        System.out.println(seller);
    }
    createValidSeller();
    match = getMatch(2);
    System.out.println(match);
    for (int i = 0; i < match.getSellers().size(); i++) {
        Seller seller = match.getSellers().get(i);
        System.out.println(seller);
    }
    */
   
   System.out.println("Cosa vuoi fare? 1.Stampa lista matches | 2.Dettagli tramite id match : ");
   Scanner sc = new Scanner(System.in);
   input = sc.next();
  
   
   if(input.equals("1")){
       int c = 1;
       Match match = getMatch(c);
       System.out.println(match);
       c++;
       match = getMatch(c);  
       System.out.println(match);
   }
   else if(input.equals("2")){
        
        System.out.println("Inserisci id match : ");
        Scanner scc = new Scanner(System.in);
        inputt = scc.next();
        scc.close();
        System.out.println(getMatch(Integer.parseInt(inputt)));
   }
   sc.close();
   client.close();
    
    }
    
    private static Seller getSeller(int matchOrder, int sellerOrder) throws IOException {
        final URL url = new URL(BASE_URL + matchOrder + "/sellers/" + sellerOrder);
        final InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), Seller.class);
    }

      private static Match getMatch(int matchOrder) throws IOException {
        final URL url = new URL(BASE_URL + matchOrder);
        final InputStream input = url.openStream();
        return JAXB.unmarshal(new InputStreamReader(input), Match.class);
    }

      
      
    private static void createValidSeller() throws IOException {
        final HttpPost httpPost = new HttpPost(BASE_URL + "2/sellers");
        final InputStream resourceStream =  Client.class.getClassLoader().getResourceAsStream("newSeller.xml");
        httpPost.setEntity(new InputStreamEntity(resourceStream));
        httpPost.setHeader("Content-Type", "text/xml");

        final HttpResponse response = client.execute(httpPost);
        
    }
    
    
}
