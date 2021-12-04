
package com.emergentes.modelo;


public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private int telefono;
    private int saldo;

    public Cliente() {
        this.id = 0;
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.telefono =0;
        this.saldo =0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }




    
    
}

