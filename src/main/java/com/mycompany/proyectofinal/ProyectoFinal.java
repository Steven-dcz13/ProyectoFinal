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
        Cliente cliente = new Cliente();
        Habitacion habitacion = new Habitacion();
        Reserva reserva = new Reserva();
        SubMenu subMenu = new SubMenu();
        
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                "Menu principal:\n" +
                "1. Registrar cliente\n" +
                "2. Registrar habitación\n" +
                "3. Crear reserva\n" +
                "4. Mostrar resumen\n" +
                "5. Salir"
            );

            if (opcion == null || opcion.equals("5")) {
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema.");
                break;
            }

            switch (opcion) {
                case "1":
                    subMenu.mostrarMenuClientes();
                    break;
                case "2":
                    habitacion.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de habitacion: ")));
                    habitacion.setTipo(JOptionPane.showInputDialog("Ingrese el tipo de habitacion: \n(Sencilla, doble, suite)"));
                    habitacion.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio por noche de la habitacion: ")));
                    break;
                case "3":
                    reserva.setCliente(cliente);
                    reserva.setHabitacion(habitacion);
                    reserva.setNoches(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de noches: ")));
                    reserva.calcularTotal();
                    break;
                case "4":
                    String resumen = "Cliente: " + cliente.getNombre() +
                                     "\nTelefono del cliente: " + cliente.getTelefono() +
                                     "\nNumero de habitacion: " + habitacion.getNumero() +
                                     "\nTipo de habitacion: " + habitacion.getTipo() +
                                     "\nPrecio por noche: " + habitacion.getPrecio() +
                                     "\nCantidad de noches: " + reserva.getNoches() +
                                     "\nTotal a pagar: " + reserva.getTotal() + " colones";
                    JOptionPane.showMessageDialog(null, resumen);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida.");
                    break;
            }
        }
    }
}
