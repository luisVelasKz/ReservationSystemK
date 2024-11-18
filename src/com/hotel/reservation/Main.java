//Main con comentarios
package com.hotel.reservation;

// Importación de clases necesarias del proyecto
import com.hotel.reservation.customer.Customer;
import com.hotel.reservation.notification.Notifier;
import com.hotel.reservation.reservation.*;
import com.hotel.reservation.room.Room;
import com.hotel.reservation.room.factories.DoubleRoomFactory;
import com.hotel.reservation.room.factories.PresidentialRoomFactory;
import com.hotel.reservation.room.factories.StandardRoomFactory;
import com.hotel.reservation.system.ReservationSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Obtiene la instancia única del sistema de reservas (Singleton)
        ReservationSystem system = ReservationSystem.getInstancia();

        // Instancia de la clase Notificable para manejar observadores
        Notifier notificable = new Notifier();

        // Scanner para capturar la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Variable de control para salir del bucle principal
        boolean exit = false;

        // Bucle principal del menú
        while (!exit) {
            // Despliega las opciones del sistema
            System.out.println("\n--- Sistema de Reservas ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Agregar Habitación");
            System.out.println("3. Crear Reserva");
            System.out.println("4. Ver Reservas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            // Captura la opción ingresada por el usuario
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer del Scanner

            try {
                outerLoop: // Etiqueta para manejar la salida del flujo
                switch (opcion) {
                    case 1 -> { // Opción para registrar un cliente
                        System.out.print("Ingrese el nombre del cliente: ");
                        String name = scanner.nextLine();
                        // Crea un nuevo cliente y lo agrega al sistema
                        Customer customer = new Customer(ReservationSystem.getCustomerId(), name);
                        system.addCustomer(customer);
                        notificable.addObserver(customer); // Registra al cliente como observador
                        System.out.println("Cliente registrado exitosamente.");
                        System.out.println("Detalle del cliente: " + customer.toString());
                    }
                    case 2 -> { // Opción para agregar una habitación
                        System.out.print("Ingrese el tipo de Habitación (Standard/Double/Presidential): ");
                        String roomType = scanner.nextLine().toUpperCase();

                        // Valida que el tipo de habitación sea válido
                        if (
                                !roomType.equals("STANDARD") &&
                                        !roomType.equals("DOUBLE") &&
                                        !roomType.equals("PRESIDENTIAL")
                        ) {
                            System.out.println("El tipo de habitación ingresado no existe");
                        } else {
                            // Crea la habitación según el tipo especificado
                            Room room;
                            if (roomType.equals("STANDARD")) {
                                room = new StandardRoomFactory().create();
                            } else if (roomType.equals("DOUBLE")) {
                                room = new DoubleRoomFactory().create();
                            } else {
                                room = new PresidentialRoomFactory().create();
                            }

                            // Agrega la habitación al sistema
                            system.addRoom(room);
                            System.out.println("Habitación agregada exitosamente.");
                            System.out.println("Detalle de la habitación: " + room.toString());
                        }

                    }
                    case 3 -> { // Opción para crear una reserva
                        // Verifica si hay clientes registrados
                        int customerCounts = system.getAllCustomers().size();

                        if (customerCounts == 0) {
                            System.out.println("No hay clientes registrados en el sistema.");
                            break;
                        }

                        System.out.print("Ingrese el ID del cliente: ");
                        int customerId = scanner.nextInt();
                        scanner.nextLine();
                        // Busca al cliente por su ID
                        Customer customerById = system.getCustomerById(customerId);

                        if (customerById == null) {
                            System.out.println("Id del usuario no existe.");
                        } else {
                            // Verifica si hay habitaciones disponibles
                            int availablesRoomsCount = system.getAllAvailableRooms().size();

                            if (availablesRoomsCount == 0) {
                                System.out.println("No hay habitaciones disponibles. Inténtalo más tarde");
                                break;
                            }

                            // Lista las habitaciones disponibles
                            System.out.println("Habitaciones disponibles:");
                            for (int i = 0; i < system.getAllRooms().size(); i++) {
                                Room room = system.getAllRooms().get(i);

                                System.out.println(i + 1 + ". " + room.getClass().getSimpleName() + " - " + (room.isAvailable() ? "Disponible" : "Ocupada"));

                            }

                            // Selecciona una habitación disponible
                            System.out.print("Seleccione el número de la habitación: ");
                            int roomNumber = scanner.nextInt() - 1;
                            scanner.nextLine();
                            Room room = system.getAllRooms().get(roomNumber);

                            // Valida que la habitación esté disponible
                            while (!room.isAvailable()) {
                                System.out.println("La habitación está ocupada. Elije otra habitación: ");
                                roomNumber = scanner.nextInt() - 1;
                                scanner.nextLine();
                                room = system.getAllRooms().get(roomNumber);
                            }

                            System.out.print("Ingrese el número de noches: ");
                            int nights = scanner.nextInt();

                            // Crea la reserva base
                            BaseReservation reservaBase = new BaseReservation(customerById, room, nights);

                            // Menú para servicios adicionales
                            System.out.println("----------------------------------");
                            System.out.println("¿Desea agregar alguno de estos servicios?");
                            System.out.println("1. Desayuno");
                            System.out.println("2. Transporte");
                            System.out.println("3. Spa");
                            System.out.println("4. No deseo agregar servicios extras");

                            int respuesta = scanner.nextInt();
                            scanner.nextLine();

                            // Valida la opción ingresada
                            while (respuesta < 1 || respuesta > 4) {
                                System.out.println("Opción no válida. Ingresa otra opción");
                                respuesta = scanner.nextInt();
                                scanner.nextLine();
                            }

                            // Agrega servicios adicionales según la opción seleccionada
                            Reservation reservation;

                            if (respuesta == 1) {
                                reservation = new BreakFastService(reservaBase);
                            } else if (respuesta == 2) {
                                reservation = new TransportService(reservaBase);
                            } else if (respuesta == 3) {
                                reservation = new SpaService(reservaBase);
                            } else {
                                reservation = reservaBase;
                            }

                            // Crea la reserva en el sistema
                            system.createReservation(reservation);
                            room.setAvailable(false); // Marca la habitación como ocupada


                            // Notifica la creación de la reserva
                            notificable.notify("Se crea una reservación a nombre de " + customerById.getName() + " en una habitación tipo " + room.getRoomType());
                            System.out.println("Reserva creada exitosamente: " + reservation.getSummary() + " | Total: $" + reservation.calculatePrice());

                        }

                    }
                    case 4 -> { // Opción para ver todas las reservas
                        System.out.println("Reservas realizadas:");
                        for (Reservation reservation : system.getAllReservation()) {
                            System.out.println(reservation.getSummary() + " | Total: $" + reservation.calculatePrice());
                        }
                    }
                    case 5 -> { // Opción para salir del sistema
                        exit = true;
                        System.out.println("Saliendo del sistema...");
                    }
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                // Captura y muestra cualquier error que ocurra
                System.err.println("Error: " + e.getMessage());
            }
        }

        // Cierra el scanner al finalizar
        scanner.close();
    }
}

