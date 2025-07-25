/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectofinal;

import javax.swing.JOptionPane;

/**
 *
 * @author Steven,Kimberlin, Montserrat,JeanCarlos
 */
public class ProyectoFinal { 

    public static void main(String[] args) {
        
        while (true){
            String opcion = JOptionPane.showInputDialog(
                    "Menu principal: \n"+
                    "1. Clientes \n"+
                    "2. Habitaciones \n"+
                    "3. Reservas \n"+
                    "4. Salir \n"
            );
            
            switch(opcion){
                case "1":
                    menuClientes();
                    break;
                case "2":
                    menuHabitaciones();
                    break;
                case "3":
                    menuReservas();
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Ha salido del sistema");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opcion no es correcta");
            }
        }       
    }
      
    //Registra el Cliente

    static void menuClientes(){

        Cliente cliente = new Cliente();
        cliente.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del cliente: "));
        cliente.setTelefono(JOptionPane.showInputDialog("Ingrese el telefono del cliente: "));
        JOptionPane.showMessageDialog(null, "El clientre ha sido registrado:\n " + cliente.getNombre());
    }
    
    //Registra la Habitacion
    
    static void menuHabitaciones(){
        
        Habitacion habitacion = new Habitacion();
        habitacion.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de habitacion: ")));
        habitacion.setTipo(JOptionPane.showInputDialog("Ingrese el tipo de habitacion: "+"\n(Sencilla, doble, suite}"));
        habitacion.setPrecio(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio por noche de la habitacion: ")));
        JOptionPane.showMessageDialog(null, "La habitacion ha sido guardada:\n " + habitacion.getNumero());
    }
    
    //Registra la Reserva
    
    static void menuReservas(){
        
        Cliente cliente = new Cliente();
        cliente.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del cliente: "));
        cliente.setTelefono(JOptionPane.showInputDialog("Ingrese el telefono del cliente: "));
        
        Habitacion habitacion = new Habitacion();
        habitacion.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de habitacion: ")));
        habitacion.setTipo(JOptionPane.showInputDialog("Ingrese el tipo de habitacion: "+"\n(Sencilla, doble, suite}"));
        habitacion.setPrecio(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio por noche de la habitacion: ")));
        
        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setHabitacion(habitacion);
        reserva.setNoches(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de noches: ")));
        
        //Calcula el monto total
        reserva.calcularTotal();
        
        // Muestra la factura de la reserva
        String resumen = "Cliente: " + cliente.getNombre()+
                         "\nTelefono del cliente: " + cliente.getTelefono()+
                         "\nNumero de habitacion: " + habitacion.getNumero()+
                         "\nTipo de habitacion: " + habitacion.getTipo()+
                         "\nPrecio por noche de la habitacion; " + habitacion.getPrecio()+
                         "\nCantidad de noches: " + reserva.getNoches()+
                         "\nTotal a pagar: " + reserva.getTotal()+ " colones";
        
        JOptionPane.showMessageDialog(null, resumen);
    }
}
