package com.hotel.reservation.reservation;

/**
 * Decorador que agregar el servicio de Spa a la reserva
 */
public class SpaService extends ServiceDecorator{

    public SpaService(Reservation reservation) {
        super(reservation);
    }

    @Override
    public double calculatePrice() {
        return reservation.calculatePrice() + 50;//Se hace un cargo de 50 al solicitar Spa
    }

    @Override
    public String getSummary() {
        return reservation.getSummary() + " Se adiciona servicio de spa.";
    }
}
