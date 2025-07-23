/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author Steven,Kimberlin, Montserrat,JeanCarlos
 */
public class Habitacion {
    private int numero;
    private String tipo;
    private double precio;
    
    public Habitacion (){
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public int getNumero(){
        return numero;
    }
    public void setTipo (String tipo){
        this.tipo = tipo;
    }
    public String getTipo(){
        return tipo;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }
    public double getPrecio(){
        return precio;
    }
}
