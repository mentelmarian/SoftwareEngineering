/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vaccinationclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
    private static CloseableHttpClient client;
    private static String input = new String();
    private static String i = new String();
    
    public static void main(String[] args) throws IOException{
    client = HttpClients.createDefault();
    
    while(true){
      System.out.println("Cosa vuoi fare?   1. Stampa la lista di tutti i vaccini   2. Maggiori dettagli paziente inserendo id vaccino");
      
        Scanner sc = new Scanner(System.in);
        input = sc.next();
        
        
        if (input.equals("1")){
            Vaccination vax = getVaccination("1");
            System.out.println(vax);
            vax = getVaccination("2");
            System.out.println(vax);
            vax = getVaccination("3");
            System.out.println(vax);
            vax = getVaccination("4");
            System.out.println(vax);
            vax = getVaccination("5");
            System.out.println(vax);
            vax = getVaccination("6");
            System.out.println(vax);
            vax = getVaccination("7");
            System.out.println(vax);
            vax = getVaccination("8");
            System.out.println(vax);
            vax = getVaccination("9");
            System.out.println(vax);
            vax = getVaccination("10");
            System.out.println(vax);
        }
        
        if (input.equals("2")){
            System.out.println("Inserisci id vaccino per avere dettagli sul paziente (sono disponibili solo id= 1, 2, 3 )");
      
            Scanner scs = new Scanner(System.in);
            i = scs.next();
            
            try { // Call Web Service Operation
                com.mycompany.personsserv.ExamImplService service = new com.mycompany.personsserv.ExamImplService();
                com.mycompany.personsserv.Exam port = service.getExamImplPort();
                // TODO initialize WS operation arguments here
                java.lang.String arg0 = i;
                // TODO process result here
                com.mycompany.personsserv.Person result = port.getPerson(i);
                System.out.println("Paziente "+result.getPersonID() + " è " + result.getName() + " " + result.getSurname() 
                        + " nato il " + result.getBirth() + " residente a " + result.getResidence() );
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }


        }
        
    }
      
   
        
    }



    private static Vaccination getVaccination(String ID) throws IOException {
        
        // JSON Marshaling
        ObjectMapper mapper = new ObjectMapper();
        final URL url = new URL(BASE_URL + "vaccinations/" + ID);
        InputStream input = url.openStream();
        Vaccination v = (Vaccination)mapper.readValue(input, Vaccination.class);        
        return v;
    }

}
