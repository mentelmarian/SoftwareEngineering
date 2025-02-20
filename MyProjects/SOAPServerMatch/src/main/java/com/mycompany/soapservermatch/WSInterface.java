/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservermatch;

import java.util.Map;
import javax.jws.WebService;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author studente
 */
@WebService
public interface WSInterface {
    
    public String helloMatch(Match match);
    
    @XmlJavaTypeAdapter(MatchMapAdapter.class)
    public Map<Integer, Match> getMatches();
}
