/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservermatch;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author studente
 */
public class MatchAdapter extends XmlAdapter<MatchImpl,Match>{
    public MatchImpl marshal(Match match) throws Exception {
        if (match instanceof MatchImpl)
            return (MatchImpl) match;
        return new MatchImpl(match.getId(), match.getDate(), match.getHome(), match.getVisitor(), match.getResult());
    }

    @Override
    public Match unmarshal(MatchImpl v) throws Exception {
        return v;
    }
}
