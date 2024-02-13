package com.mycompany.gestionalimentos.entidad;

public class Compra extends Transaccion {

    public String nombreCompra;
    public double precioUnitario;
    public String descripcion;

    public Compra(String nombre, int numerotelefono, String direccion) {
        super(nombre, numerotelefono, direccion);
    }
   
    public Compra(String nombre, 
                  String direccion, 
                  int numerotelefono, 
                  String nombreCompra, 
                  double preciounitario,
                  String descripcion) {
        
        super(nombre, numerotelefono, direccion);
        this.nombreCompra = nombreCompra;
        this.precioUnitario = preciounitario;
        this.descripcion = descripcion;
    }

    public String generarMensaje() {
        return "Compra;" + nombre + ";" + direccion + ";" + numerotelefono + ";" + nombreCompra + ";" + precioUnitario + ";" + descripcion;
    }

    public String getNombreCompra() {
        return nombreCompra;
    }

    public void setNombreCompra(String nombreCompra) {
        this.nombreCompra = nombreCompra;
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
