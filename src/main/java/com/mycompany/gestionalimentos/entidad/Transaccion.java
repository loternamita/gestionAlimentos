package com.mycompany.gestionalimentos.entidad;

public class Transaccion {

    public String nombre;
    public String direccion;
    public int numerotelefono;
    
    public Transaccion(String nombre, int numerotelefono, String direccion){
        this.nombre = nombre;
        this.direccion = direccion;
        this.numerotelefono = numerotelefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumerotelefono() {
        return numerotelefono;
    }

    public void setNumerotelefono(int numerotelefono) {
        this.numerotelefono = numerotelefono;
    }
}
