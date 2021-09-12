/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapclientmatch;

import com.mycompany.soapservermatch.Match;
import com.mycompany.soapservermatch.MatchEntry;
import com.mycompany.soapservermatch.MatchMap;
import java.util.List;

/**
 *
 * @author studente
 */
public class SOAPClientMatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Match m = new Match();
        m.setId(3);
        m.setDate("22/10/2009");
        m.setHome("Casa");
        m.setVisitor("Ospiti");
        m.setResult("2-1");
        System.out.println("Aggiunto" + SOAPClientMatch.helloMatch(m));
        
        
        List<MatchEntry> result = SOAPClientMatch.getMatches().getEntry();
        for (int i = 0 ; i<result.size(); i++){
            System.out.println(((MatchEntry)result.get(i)).getMatch().getId());
            System.out.println(((MatchEntry)result.get(i)).getMatch().getDate());
            System.out.println(((MatchEntry)result.get(i)).getMatch().getHome());
            System.out.println(((MatchEntry)result.get(i)).getMatch().getVisitor());
            System.out.println(((MatchEntry)result.get(i)).getMatch().getResult());
        }
    }
        

    private static MatchMap getMatches() {
        com.mycompany.soapservermatch.WSImplService service = new com.mycompany.soapservermatch.WSImplService();
        com.mycompany.soapservermatch.WSInterface port = service.getWSImplPort();
        return port.getMatches();
    }

    private static String helloMatch(com.mycompany.soapservermatch.Match arg0) {
        com.mycompany.soapservermatch.WSImplService service = new com.mycompany.soapservermatch.WSImplService();
        com.mycompany.soapservermatch.WSInterface port = service.getWSImplPort();
        return port.helloMatch(arg0);
    }
    
    
    
}
