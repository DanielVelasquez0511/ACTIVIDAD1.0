package com.software2.backend.modelo;

public class Moto {
    private Long id;
    private String nombre;
    private double precio;
    private double peso;

    public Moto() {
    }

    public Moto(Long id, String nombre, double precio, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.peso = peso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
