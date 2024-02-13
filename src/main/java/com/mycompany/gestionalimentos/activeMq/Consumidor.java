
package com.mycompany.gestionalimentos.activeMq;

import com.mycompany.gestionalimentos.db.DBUtil;
import com.mycompany.gestionalimentos.entidad.Compra;
import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageConsumer;
import jakarta.jms.MessageListener;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Consumidor implements MessageListener{
    
    private String cola;
    
    public Consumidor(String cola) throws JMSException {
        this.cola = cola;
        Session session = ActiveMQUtils.obtenerConexion();
        Destination destino = session.createQueue(cola);
        MessageConsumer consumer = session.createConsumer(destino);
        consumer.setMessageListener(this);
    }

    @Override
    public void onMessage(Message message) {
       try {
          if (message instanceof TextMessage) {
             TextMessage textmessage = (TextMessage) message;
             
             String msgContent = textmessage.getText();
             String[] parts = msgContent.split(";");
             String tipoTransaccion = parts[0];
             
             if(tipoTransaccion == "Compra"){
                 String nombreTransaccion = parts[1];
                 String direccion = parts[2];
                 int numerotelefono = Integer.parseInt(parts[3]);
                 Compra compra = new Compra(nombreTransaccion, numerotelefono, direccion);
                 compra.setNombreCompra(parts[4]);
                 compra.setPrecioUnitario(Double.parseDouble(parts[5]));
                 compra.setDescripcion(parts[6]);
               
                 insertarCompra(compra);
                 
             }
          }     
       } catch (Exception e) {
          e.printStackTrace();
       }
    }
    
    
    private void insertarCompra(Compra compra){
       
        Connection conexion = null;
        
        try {
            
            conexion = DBUtil.obtenerConexionMysql();
            conexion.setAutoCommit(false);
            
            String insertTransaccionSQL = "INSERT INTO sucursales (nombre, direccion, numero_telefono) VALUES (?,?,?) ";
            try( PreparedStatement psmt = conexion.prepareStatement(insertTransaccionSQL)      ){
               psmt.setString(1, compra.getNombre());
               psmt.setString(2, compra.getDireccion());
               psmt.setString(3, Integer.toString(compra.getNumerotelefono()));
               psmt.executeUpdate();
            }
            
            String insertProductosSQL = "INSERT INTO productos (nombre, descripcion, precio) VALUES (?,?,?)";
            try(PreparedStatement psmt = conexion.prepareStatement(insertProductosSQL)){
               psmt.setString(1, compra.getNombreCompra());
               psmt.setString(2, compra.getDescripcion());
               psmt.setDouble(3, compra.getPrecioUnitario());
               psmt.executeUpdate();
            }
            
            conexion.commit();

        } catch (SQLException e) {
            try {
                if (conexion != null) conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
               if(conexion != null){
                  conexion.setAutoCommit(true);
                  conexion.close();
               }
            } catch (SQLException exf) {
               exf.printStackTrace();
            }
        }
    }


}
