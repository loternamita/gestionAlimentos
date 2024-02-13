
package com.mycompany.gestionalimentos.entidad;




public class Venta extends Transaccion {
    
    public String nombreVenta;
    public double precioUnitario;
    public String descripcion;

    public Venta(String nombre, 
                  String direccion, 
                  int numerotelefono,
                  String nombreVenta, 
                  double preciounitario,
                  String descripcion) {
        
        super(nombre, numerotelefono, direccion);
        this.nombreVenta = nombreVenta;
        this.precioUnitario = preciounitario;
        this.descripcion = descripcion;
    }
    
    public String generarMensaje() {
        return "Venta;" + nombre + ";" + direccion + ";" + numerotelefono + ";" + nombreVenta + ";" + precioUnitario + ";" + descripcion;
    }

    public String getNombreVenta() {
        return nombreVenta;
    }

    public void setNombreVenta(String nombreVenta) {
        this.nombreVenta = nombreVenta;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
