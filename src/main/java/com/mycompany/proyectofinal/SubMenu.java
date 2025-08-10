/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import javax.swing.JOptionPane;

/**
 *
 * @author stcaz
 */
public class SubMenu {
   Cliente[] clientes;

    public void mostrarMenuClientes() {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Submenu Clientes:\n" +
                    "1. Registrar clientes\n" +
                    "2. Mostrar resumen de clientes\n" +
                    "3. Volver al menu principal");

            if (opcion == null || opcion.equals("3")) {
                break;
            }

            switch (opcion) {
                case "1":
                    menuRegistrarClientes();
                    break;
                case "2":
                    menuMostrarResumenClientes();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida.");
            }
        }
    }

    public void menuRegistrarClientes() {
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cuantos clientes desea registrar?"));

        clientes = new Cliente[cantidad];

        for (int i = 0; i < cantidad; i++) {
            Cliente cliente = new Cliente();
            cliente.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del cliente " + (i + 1) + ": "));
            cliente.setTelefono(JOptionPane.showInputDialog("Ingrese el teléfono del cliente " + (i + 1) + ": "));
            clientes[i] = cliente;
        }

        JOptionPane.showMessageDialog(null, "Clientes registrados exitosamente.");
    }

    public void menuMostrarResumenClientes() {
        if (clientes == null || clientes.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
            return;
        }

        String resumen = "Lista de Clientes:\n";
        for (int i = 0; i < clientes.length; i++) {
            resumen += (i + 1) + ". Nombre: " + clientes[i].getNombre() + ", Telefono: " + clientes[i].getTelefono() + "\n";
        }

        JOptionPane.showMessageDialog(null, resumen);
    }

}
