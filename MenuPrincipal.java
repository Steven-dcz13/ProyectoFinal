package com.mycompany.proyectofinal;

import javax.swing.JOptionPane;

public class MenuPrincipal {

    public static void mostrarMenu() {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Menu principal: \n" +
                    "1. Clientes \n" +
                    "2. Habitaciones \n" +
                    "3. Reservas \n" +
                    "4. Salir \n"
            );

            switch (opcion) {
                case "1":
                    ProyectoFinal.menuClientes();
                    break;
                case "2":
                    ProyectoFinal.menuHabitaciones();
                    break;
                case "3":
                    ProyectoFinal.menuReservas();
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Ha salido del sistema");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción no es correcta");
            }
        }
    }
}