
package com.mycompany.gestionalimentos.activeMq;

import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.MessageProducer;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

public class Productor {
    
    private Session session;
    private MessageProducer producer;

    public void enviarMensaje(String cola, String mensaje) throws JMSException {
        Session session = ActiveMQUtils.obtenerConexion();
        Destination destino = session.createQueue(cola);
        MessageProducer producer = session.createProducer(destino);
        TextMessage message = session.createTextMessage(mensaje);
        producer.send(message);
        session.close();
    }
}
