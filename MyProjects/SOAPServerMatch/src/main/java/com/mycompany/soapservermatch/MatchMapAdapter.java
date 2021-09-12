/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservermatch;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author matche
 */
public class MatchMapAdapter extends XmlAdapter<MatchMap, Map<Integer,Match>>{
     @Override
    public Map<Integer,Match> unmarshal(MatchMap v) throws Exception {
        LinkedHashMap<Integer,Match> boundMap = new LinkedHashMap<Integer, Match>();
        for (MatchMap.MatchEntry matchEntry : v.getEntries()) {
            boundMap.put(matchEntry.getId(), matchEntry.getMatch());
        }
        return boundMap;
    }

    @Override
    public MatchMap marshal(Map<Integer, Match> boundMap) throws Exception {
        MatchMap valueMap = new MatchMap();
        for (Map.Entry<Integer, Match> boundEntry : boundMap.entrySet()) {
            MatchMap.MatchEntry valueEntry = new MatchMap.MatchEntry();
            valueEntry.setMatch(boundEntry.getValue());
            valueEntry.setId(boundEntry.getKey());
            valueMap.getEntries().add(valueEntry);
        }
        return valueMap;
    }
}
