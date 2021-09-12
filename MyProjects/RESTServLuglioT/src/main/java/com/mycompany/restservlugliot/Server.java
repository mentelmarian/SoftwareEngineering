/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restservlugliot;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import java.util.ArrayList;
import java.util.List;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author studente
 */
public class Server {
    public static void main(String args[]) throws Exception {
        
        JAXRSServerFactoryBean factoryB = new JAXRSServerFactoryBean();
        factoryB.setResourceClasses(TeamRepository.class);
        TeamRepository f = new TeamRepository();
        f.setConnection("/home/studente/luglio.db");
        factoryB.setResourceProvider(new SingletonResourceProvider(f));
        factoryB.setAddress("http://localhost:8090/");
  
        

        List<Object> providerss = new ArrayList<Object>();
        providerss.add(new JacksonJaxbJsonProvider());

        factoryB.setProviders(providerss);
       
        
        BindingFactoryManager managerr = factoryB.getBus().getExtension(BindingFactoryManager.class);
        JAXRSBindingFactory restFactoryy = new JAXRSBindingFactory();
        restFactoryy.setBus(factoryB.getBus());
        managerr.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, restFactoryy);

        org.apache.cxf.endpoint.Server serverr = factoryB.create();

        System.out.println("Server ready...");

        while (true) {
        }
    }
}
