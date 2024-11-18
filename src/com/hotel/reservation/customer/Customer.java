package com.hotel.reservation.customer;

import com.hotel.reservation.notification.Observer;

/**
 * Clase que define el comportamiento y atributos de los clientes.
 * Se implementa Observer para que los
 * clientes puedan ser notificados siempre que hagan una reserva
 */
public class Customer implements Observer {

    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método que se utiliza Observer para enviar mensajes
     * @param message
     */
    @Override
    public void update(String message) {
        System.out.println("Usuario " + this.name + ", tienes el siguiente mensaje: " + message);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
