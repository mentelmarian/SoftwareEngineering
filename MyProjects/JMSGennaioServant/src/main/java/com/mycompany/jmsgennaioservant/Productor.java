/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jmsgennaioservant;


import java.util.*;
import javax.jms.*;
import javax.naming.*;


/**
 *
 * @author studente
 */
public class Productor {
    private Random randomGen = new Random();
    final String titoli[] = { "Telecom", "Finmeccanica", "Banca_Intesa",
			"Oracle", "Parmalat", "Mondadori", "Vodafone", "Barilla" };
    


    private String scegliNumero() {  
        // Generate random integers in range 0 to 9   
        int rand_int = randomGen.nextInt(10);
        return Integer.toString(rand_int);
    }
    
    private String scegliMessaggio() {        
        int whichMsg;
        whichMsg = randomGen.nextInt(this.titoli.length);
        return this.titoli[whichMsg];
    }


    public void start() throws NamingException, JMSException {
        Properties properties = null;
        Context jndiContext = null;

        try {
            properties = new Properties();
            properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            properties.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            jndiContext = new InitialContext(properties);
        } catch (NamingException e) {
            System.out.println(e.toString());
            System.exit(1);
        }
        
        ConnectionFactory connectionFactory = (ConnectionFactory)jndiContext.lookup("ConnectionFactory");
        Destination destination = (Destination)jndiContext.lookup("dynamicTopics/1705340");

        Connection connection = (Connection) connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer = session.createProducer(destination);

        int item = 0;
        String numero;
        String messaggio;
        TextMessage message = session.createTextMessage();
        while (true) {
            numero = scegliNumero();
            
            message.setStringProperty("id", numero);
            messaggio = scegliMessaggio();
            message.setText(messaggio);

            producer.send(message);
            System.out.println(numero + "->" + messaggio);
            item += 1;

            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
