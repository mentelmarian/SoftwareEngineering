/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservermatch;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author studente
 */
@XmlType(name = "MatchMap")
public class MatchMap {
    private List<MatchEntry> entries = new ArrayList<MatchEntry>();

    @XmlElement(nillable = false, name = "entry")
    public List<MatchEntry> getEntries() {
        return entries;
    }

    @XmlType(name = "MatchEntry")
    public static class MatchEntry {

        private Integer id;
        private String date;
        private String home;
        private String visitor;
        private String result;
        private Match match;

        public Integer getId() { return id; }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        public String getVisitor() {
            return visitor;
        }

        public void setVisitor(String visitor) {
            this.visitor = visitor;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
        
        public Match getMatch () { return match; }
     
        public void setId(Integer i) { id = i; }
        public void setMatch(Match m) { match = m; }
        
    }
}
