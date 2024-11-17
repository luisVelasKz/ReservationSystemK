package com.hotel.reservation.notification;

/**
 * Interfaz que contiene el método que se utilizará para notificar nuevas reservas
 */
public interface Observer {
    /**
     *
     * @param message
     */
    void update(String message);
}
