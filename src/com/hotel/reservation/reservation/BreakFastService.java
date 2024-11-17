package com.hotel.reservation.reservation;

/**
 * Decorador que agregar el servicio de desayuno a la reserva
 */
public class BreakFastService extends ServiceDecorator{

    public BreakFastService(Reservation reservation) {
        super(reservation);
    }

    @Override
    public double calculatePrice() {
        return reservation.calculatePrice() + 20;//Se hace un cargo de 20 al solicitar desayuno
    }

    @Override
    public String getSummary() {
        return reservation.getSummary() + " Se adiciona servicio de desayuno.";
    }
}
