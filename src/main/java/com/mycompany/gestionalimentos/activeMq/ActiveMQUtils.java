
package com.mycompany.gestionalimentos.activeMq;


import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import jakarta.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQUtils {
    
    public static String url = "tcp://localhost:61616";
    
    public static Session obtenerConexion() throws JMSException {
       ConnectionFactory connectionfactory = new ActiveMQConnectionFactory(url);
       Connection connection = connectionfactory.createConnection();
       connection.start();
       return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }
}
