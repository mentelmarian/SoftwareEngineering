/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservermatch;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author studente
 */
@WebService(endpointInterface = "com.mycompany.soapservermatch.WSInterface")
public class WSImpl implements WSInterface{
    private Map<Integer, Match> matches
            = new LinkedHashMap<Integer, Match>();

    public String helloMatch(Match match) {
        matches.put(matches.size() + 1, match);
        return "Hello " + match.getId();
    }

    public Map<Integer, Match> getMatches() {
        return matches;
    }
}
