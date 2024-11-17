package com.hotel.reservation.reservation;

/**
 * Interface que define el comportamient básico de una reserva
 */
public interface Reservation {
    /**
     *
     * @return precio de la reserva
     */
    double calculatePrice();

    /**
     *
     * @return resumen de la reserva
     */
    String getSummary();
}
