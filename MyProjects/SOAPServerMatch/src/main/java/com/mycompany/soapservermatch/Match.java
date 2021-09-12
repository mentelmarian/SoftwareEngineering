/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservermatch;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author studente
 */
@XmlJavaTypeAdapter(MatchAdapter.class)
public interface Match {
    public int getId();
    public String getDate();
    public String getHome();
    public String getVisitor();
    public String getResult();
}
