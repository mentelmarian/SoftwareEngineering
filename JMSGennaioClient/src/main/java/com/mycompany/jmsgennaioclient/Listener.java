/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jmsgennaioclient;

import java.util.*;
import javax.jms.*;
import javax.naming.*;

/**
 *
 * @author studente
 */
public class Listener implements MessageListener{
    private Connection connection;
    private TopicConnection jmsConnection;
    private static String input = new String();


    public Listener() {
        System.out.println("Scegli numero:");
        Scanner sc = new Scanner(System.in);
        input = sc.next();
        sc.close();
        
        try {
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
            Context ctx = new InitialContext(props);

            ConnectionFactory connectionFactory = (ConnectionFactory)ctx.lookup("ConnectionFactory");
            jmsConnection = (TopicConnection)connectionFactory.createConnection();
            TopicSession session = (TopicSession) jmsConnection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = (Destination)ctx.lookup("dynamicTopics/1705340");
            TopicSubscriber subscriber = session.createSubscriber((Topic)destination);
            subscriber.setMessageListener(this);

        } catch (JMSException | NamingException err) {
            err.printStackTrace();
            System.exit(1);
        }
    }

    public void stampa(String numero, String text, String input){
        if (numero.equals(input))
        System.out.println(String.format("%s -> %s", numero, text));
    }

    public void onMessage(Message msg) {
        try {
            String numero = msg.getStringProperty("id");
            String text = ((TextMessage)msg).getText();
            stampa(numero, text, input);
        } catch (JMSException err) {
            err.printStackTrace();
        }
    }


    public void start() {
        
        try {
            jmsConnection.start();
        } catch (JMSException err) {
            err.printStackTrace();
        }
    }


    public void stop() {
        try {
            jmsConnection.stop();
        } catch (JMSException err) {
            err.printStackTrace();
        }
    }
}
