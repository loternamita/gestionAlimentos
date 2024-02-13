package com.mycompany.gestionalimentos;

import com.mycompany.gestionalimentos.activeMq.Consumidor;
import com.mycompany.gestionalimentos.activeMq.Productor;
import com.mycompany.gestionalimentos.entidad.Compra;
import jakarta.jms.JMSException;

/**
 *
 * @author andres
 */
public class GestionAlimentos {

    public static void main(String[] args) throws JMSException {

        //Productor productor = new Productor();
        Compra compra = new Compra("Avenida 32", "calle tal con tal", 316222026, "televisor", 5000000, "me salio dañado");
        
        System.out.println("valores: " + compra.generarMensaje());
        
        // Envia el mensaje
        //productor.enviarMensaje("Transaccionqueue", compra.generarMensaje());
        
        
        // Consumidor
        //Consumidor consumidor = new Consumidor("Transaccionqueue");
        
        
        
    }
}
