package com.hotel.reservation.reservation;

/**
 * Decorador que agregar el servicio de transporte a la reserva
 */
public class TransportService extends ServiceDecorator{

    public TransportService(Reservation reservation) {
        super(reservation);
    }

    @Override
    public double calculatePrice() {
        return reservation.calculatePrice() + 100;//Se hace un cargo de 100 al solicitar transporte
    }

    @Override
    public String getSummary() {
        return reservation.getSummary() + " Se adiciona servicio de transporte.";
    }

}
