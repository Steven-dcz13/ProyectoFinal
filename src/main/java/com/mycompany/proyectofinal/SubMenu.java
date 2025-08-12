/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectofinal;

import javax.swing.JOptionPane;

/**
 *
 * @author Steven,Kimberlin, Montserrat,JeanCarlos
 */
public class SubMenu {
    
    Cliente cliente; //Crea la clase cliente
    Cliente[] clientes = new Cliente[2];//Crea el array para almacenar los clientes
    Reserva reserva;//Crea la clase reserva
    Reserva[] reservas = new Reserva[2];//Crea el array para almacenar las reservas
    Habitacion habitacion;//Crea la clase habitacion
    Habitacion[] habitaciones = new Habitacion[2];//Crea el array para almacenar las habitaciones
    int cantidadClientes = 0;//Crea el contador para cargar el array de clientes, siempre se inicia en cero
    int cantidadReservas = 0;//Crea el contador para cargar el array de reservas, siempre se inicia en cero
    int cantidadHabitaciones =0;//Crea el contador para cargar el array de clientes, siempre se inicia en cero
    
    public void mostrarMenuClientes() {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Submenu Clientes:\n"
                    + "1. Registrar clientes\n"
                    + "2. Mostrar resumen de clientes\n"
                    + "3. Volver al menu principal");

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
                    JOptionPane.showMessageDialog(null, "Opcion invalida, intente nuevamente");
            }
        }
    }

    public void menuRegistrarClientes() {
        if (cantidadClientes < clientes.length) {
            cliente = new Cliente();
            cliente.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del cliente " + (cantidadClientes + 1) + ": "));
            cliente.setTelefono(JOptionPane.showInputDialog("Ingrese el teléfono del cliente " + (cantidadClientes + 1) + ": "));
            clientes[cantidadClientes] = cliente;
            cantidadClientes++;
            JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Se ha alcanzado el limite de clientes registrados.");
        }

    }

    public void menuMostrarResumenClientes() {
        String resumen = "Lista de Clientes registrados:\n";
        if (clientes == null || clientes.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados.");
        } else {
            for (int i = 0; i < clientes.length; i++) {
                if (clientes[i] == null) {
                    break;
                }
                resumen += (i + 1) + ". Nombre: " + clientes[i].getNombre() + ", Telefono: " + clientes[i].getTelefono() + "\n";
            }
            JOptionPane.showMessageDialog(null, resumen);
        }
    }

    public void mostrarMenuHabitacion() {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Submenu Habitacion:\n"
                    + "1. Registrar habitaciones\n"
                    + "2. Mostrar resumen de habitaciones\n"
                    + "3. Volver al menu principal");

            if (opcion == null || opcion.equals("3")) {
                break;
            }

            switch (opcion) {
                case "1":
                    menuRegistrarHabitaciones();
                    break;
                case "2":
                    menuMostrarResumenHabitaciones();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida.");
            }
        }
    }

    public void menuRegistrarHabitaciones() {
        if (cantidadHabitaciones < habitaciones.length) {
            habitacion = new Habitacion();
            habitacion.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de habitacion:")));
            habitacion.setTipo(JOptionPane.showInputDialog("Ingrese el tipo de habitacion:\n(Sencilla, Doble, Suite)"));
            habitacion.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio por noche de la habitacion: ")));
            habitaciones[cantidadHabitaciones] = habitacion;
            cantidadHabitaciones++;
            JOptionPane.showMessageDialog(null, "Habitacion registrada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Se ha alcanzado el limite de habitaciones registradas");
        }

    }

    public void menuMostrarResumenHabitaciones() {
        if (cantidadHabitaciones == 0) {
            JOptionPane.showMessageDialog(null, "No hay habitaciones registradas.");
            return;
        }

        String resumen = "Lista de Habitaciones registradas:\n";
        for (int i = 0; i < cantidadHabitaciones; i++) {
            resumen += (i + 1) + ". Numero: " + habitaciones[i].getNumero()
                    + ", Tipo: " + habitaciones[i].getTipo()
                    + ", Precio: ₡ " + habitaciones[i].getPrecio() + "\n";
        }

        JOptionPane.showMessageDialog(null, resumen);
    }

    public void mostrarMenuReserva() {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "Submenu Reserva:\n"
                    + "1. Crear reservacion\n"
                    + "2. Mostrar resumen de reservaciones\n"
                    + "3. Volver al menu principal");

            if (opcion == null || opcion.equals("3")) {
                break;
            }

            switch (opcion) {
                case "1":
                    menuCrearReserva();
                    break;
                case "2":
                    menuMostrarResumenReserva();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida.");
            }
        }
    }

    public void menuCrearReserva() {
        if (cantidadClientes == 0) {
            JOptionPane.showMessageDialog(null, "Primero registre clientes en el submenu de clientes.");
            return;
        }
        if (cantidadHabitaciones == 0) {
            JOptionPane.showMessageDialog(null, "Primero registre habitaciones en el submenu de habitacion.");
            return;
        }

        String listaClientes = "Elija el numero de cliente:\n";
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                break;
            }
            listaClientes += (i + 1) + ". " + clientes[i].getNombre() + " - " + clientes[i].getTelefono() + "\n";
        }
        int ClienteRegistrado = Integer.parseInt(JOptionPane.showInputDialog(listaClientes));
        if (ClienteRegistrado < 1 || ClienteRegistrado > clientes.length) {
            JOptionPane.showMessageDialog(null, "Numero de cliente invalido.");
            return;
        }
        Cliente clienteSeleccionado = clientes[ClienteRegistrado - 1];

        String listaHabitaciones = "Elija el numero de habitacion:\n";
        for (int i = 0; i < cantidadHabitaciones; i++) {
            listaHabitaciones += (i + 1) + ". Habitacion :" + habitaciones[i].getNumero()
                    + ", Tipo: " + habitaciones[i].getTipo()
                    + ", Precio: ₡ " + habitaciones[i].getPrecio() + "\n";
        }
        int HabitacionRegistrada = Integer.parseInt(JOptionPane.showInputDialog(listaHabitaciones));
        if (HabitacionRegistrada < 1 || HabitacionRegistrada > cantidadHabitaciones) {
            JOptionPane.showMessageDialog(null, "Numero de habitacion invalido.");
            return;
        }
        Habitacion HabitacionSeleccionada = habitaciones[HabitacionRegistrada - 1];

        int noches = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de noches:"));
        
        if (cantidadReservas < reservas.length) {
            reserva = new Reserva();
            reserva.setCliente(clienteSeleccionado);
            reserva.setHabitacion(HabitacionSeleccionada);
            reserva.setNoches(noches);
            reserva.calcularTotal();
            reservas[cantidadReservas] = reserva;
            cantidadReservas++;
            JOptionPane.showMessageDialog(null, "Reserva registrada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Se ha alcanzado el limite de resrvas disponibles.");
        }
    }

    public void menuMostrarResumenReserva() {
        if (reservas == null || reservas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay reserva creada.");
            return;
        }

        String resumen = "Lista de Reservas:\n";
        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i] == null) {
                break;
            }
            resumen += (i + 1) + ". Cliente: " + reservas[i].getCliente().getNombre()
                    + " | Tel: " + reservas[i].getCliente().getTelefono()
                    + " | Hab: " + reservas[i].getHabitacion().getNumero()
                    + " (" + reservas[i].getHabitacion().getTipo() + ")"
                    + " | Precio: ₡ " + reservas[i].getHabitacion().getPrecio()
                    + " | Noches: " + reservas[i].getNoches()
                    + " | Total a pagar: ₡ " + reservas[i].getTotal() + "\n";
            
        }

        JOptionPane.showMessageDialog(null, resumen);
    }
}
