/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.personsserv;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author studente
 */
@WebService(endpointInterface = "com.mycompany.personsserv.Exam")
public class ExamImpl implements Exam {
    protected static Map<Integer, Person> persons = new LinkedHashMap<Integer, Person>();
    
    public Person getPerson(String ID) {
        return persons.get(Integer.parseInt(ID));
    }
}
