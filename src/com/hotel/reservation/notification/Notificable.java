package com.hotel.reservation.notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que almacena todos los observadores (Clientes) que serán notificados
 * al momento de crearse una reserva
 */
public class Notificable {
    private List<Observer> observers = new ArrayList<>();

    /**
     *
     * @param observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Se notifica a todos los Clientes utilizando el método update que implementa la clase Customer
     * @param message
     */
    public void notify(String message) {
        System.out.println("***NOTIFICACIONES DEL SISTEMA***");
        for (Observer observador : observers) {
            observador.update(message);
        }
        System.out.println("***NOTIFICACIONES DEL SISTEMA***");
    }
}
