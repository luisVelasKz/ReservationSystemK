package com.hotel.reservation.reservation;

import com.hotel.reservation.customer.Customer;
import com.hotel.reservation.customer.CustomerManager;
import com.hotel.reservation.room.Room;
import com.hotel.reservation.room.RoomManager;

public class ReservationManager {
    private final CustomerManager customerManager;
    private final RoomManager roomManager;

    public ReservationManager(CustomerManager customerManager, RoomManager roomManager) {
        this.customerManager = customerManager;
        this.roomManager = roomManager;
    }

    public void reserveRoom(Customer customer, Room room) {
        // Lógica para hacer una reserva
        System.out.println("Reserva realizada para " + customer.getName() + " en la habitación " );
    }
}