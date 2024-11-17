package com.hotel.reservation.reservation;

/**
 * Clase Decoradora que permite agregar un servicio extra a la reserva
 */
public abstract class ServiceDecorator implements Reservation{

    protected Reservation reservation;

    public ServiceDecorator(Reservation reservation){
        this.reservation = reservation;
    }

    @Override
    public double calculatePrice() {
        return reservation.calculatePrice();
    }

    @Override
    public String getSummary() {
        return reservation.getSummary();
    }
}
