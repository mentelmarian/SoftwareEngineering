/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restcldb;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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

    public static void main(String[] args) throws IOException{
    client = HttpClients.createDefault();
    
    // Example GET
    Student student = getStudent(3878);
    System.out.println(student);
    
  
    
    //PUT example, non funziona
    
    createValidStudent();
    Student studentt = getStudent(4);
    System.out.println(studentt);
    
    client.close();
        
    }



    private static Student getStudent(int id) throws IOException {
        
        // JSON Marshaling
        ObjectMapper mapper = new ObjectMapper();
        final URL url = new URL(BASE_URL + "students/" + id);
        InputStream input = url.openStream();
        Student st = (Student)mapper.readValue(input, Student.class);        
        return st;
    }

    private static void createValidStudent() throws IOException {
        
        // JSON Marshaling
        ObjectMapper objectMapper = new ObjectMapper();
        Student newSt = new Student();
        
        newSt.setId(4);
        newSt.setNome("XX000");
        newSt.setCognome("ciao");
        
        
        String json = objectMapper.writeValueAsString(newSt); 
        
        HttpPut httpPut;
        httpPut = new HttpPut(BASE_URL + "students");
        
        StringEntity entity = new StringEntity(json);
        httpPut.setEntity(entity);
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");
        HttpResponse response = client.execute(httpPut);
        System.out.println(response);
    }
 

}
