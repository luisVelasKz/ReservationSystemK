package com.hotel.reservation.system;

import com.hotel.reservation.customer.Customer;
import com.hotel.reservation.reservation.BaseReservation;
import com.hotel.reservation.reservation.Reservation;
import com.hotel.reservation.room.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase general que determina el comportameinto del sistema
 * Almacena todos los clientes, Cuartos y Reservas.
 * Se utiliza el patrón de diseño Singleton para tener una única instancia de esta clase general
 */
public class ReservationSystem {
    private static ReservationSystem instance;
    private final List<Customer> customers;
    private final List<Room> rooms;
    private final List<Reservation> reservations;
    private static int customerId = 1;//almacena el último id de cliente

    private ReservationSystem() {
        customers = new ArrayList<>();
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    /**
     *
     * @return instancia única de clase ReservationSystem
     */
    public static synchronized ReservationSystem getInstancia() {
        if (instance == null) {
            instance = new ReservationSystem();
        }
        return instance;
    }

    /**
     * Retorna el último ID de cliente que se ha utilizado y posteriormente se suma 1
     * ya que ese será el nuevo ID que se asigne a un nuevo cliente que se cree
     * @return ID de cliente
     */
    public static int getCustomerId(){
        return customerId++;
    }

    /**
     * Se registra el cliente en el sistema
     * @param customer
     */
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    /**
     * Se registra la habitación en el sistema
     * @param room
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Se registra la reserva en el sistema
     * @param reservation
     */
    public void createReservation(Reservation reservation){
        reservations.add(reservation);
    }

    /**
     *
     * @param id
     * @return el cliente con ID @param id. Si no existe cliente con el ID
     * que proporciona el usuario, retorna null
     */
    public Customer getCustomerById(int id){
        Customer customerId = null;

        for(Customer customer: customers){
            if(customer.getId() == id){
                customerId = customer;
                break;
            }
        }
        return customerId;
    }

    /**
     *
     * @return lista de todos los clientes registrados en el sistema
     */
    public List<Customer> getAllCustomers(){
        return customers;
    }

    /**
     *
     * @return lista de todos las habitaciones registradas en el sistema
     */
    public List<Room> getAllRooms(){
        return rooms;
    }

    /**
     *
     * @return lista de todas las reservaciones registradas en el sistema
     */
    public List<Reservation> getAllReservation(){
        return reservations;
    }

    /**
     *
     * @return lista de todas las habitaciones disponibles registradas en el sistema
     */
    public List<Room> getAllAvailableRooms(){
        List<Room> roomsAvailables = new ArrayList<>();
        for (Room room: rooms){
            if(room.isAvailable()){
                roomsAvailables.add(room);
            }
        }
        return roomsAvailables;
    }
}
