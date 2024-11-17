package com.hotel.reservation.reservation;

import com.hotel.reservation.customer.Customer;
import com.hotel.reservation.room.Room;

/**
 * Clase base de una reserva. Implementa la interfaz Reservation
 */
public class BaseReservation implements Reservation{

    private Customer customer;
    private Room room;
    private int nights;//Número de noches que se hospedará el cliente

    public BaseReservation(Customer customer, Room room, int nights){
        this.customer = customer;
        this.room = room;
        this.nights = nights;
    }

    /**
     * Ya que es la reserva base, retorna por defecto el mismo cálculo que genera la habitación
     * @return precio de la reservación
     */
    @Override
    public double calculatePrice() {
        return room.calculatePrice(this.nights);
    }

    /**
     *
     * @return Resumen de la reserva
     */
    @Override
    public String getSummary() {
        return "Reserva para " + customer.getName() + " en habitación " + room.getRoomType();
    }
}
