/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

/**
 *
 * @author Steven,Kimberlin, Montserrat,JeanCarlos
 */
public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private int noches;
    private double total;
    
    public Reserva(){
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void setHabitacion(Habitacion habitacion){
        this.habitacion = habitacion;
    }
    public Habitacion getHabitacion(){
        return habitacion;
    }
    public void setNoches(int noches){
        this.noches = noches;
    }
    public int getNoches(){
        return noches;
    }
    public void calcularTotal(){
        total = habitacion.getPrecio()*noches;
    }
    public double getTotal(){
        return total;
    }
}

