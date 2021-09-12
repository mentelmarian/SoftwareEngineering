/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservluglio;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author studente
 */
@WebService(endpointInterface = "com.mycompany.soapservluglio.Exam")
public class ExamImpl implements Exam{
    
    protected static Map<Integer, Ticket> tickets = new LinkedHashMap<Integer, Ticket>();
    
    public Ticket getTicket(int matchId) {
        return tickets.get(matchId);
    }
    
    
}
