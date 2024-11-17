package com.hotel.reservation.room;

/**
 * Clase abstracta que define el comportamiento y atributos de una habitación
 */
public abstract class Room {
    protected RoomType roomType;//Tipo de habitación definida por enum RunTime
    protected boolean isAvailable;//Determina si la habitación está ocupada o libre

    public Room(RoomType type) {
        this.roomType = type;
        this.isAvailable = true;
    }

    /**
     * Método que calcula el precio de la habitación en base a las noches que se hospedará el cliente
     * @param nights
     * @return
     */
    public abstract double calculatePrice(int nights);

    /**
     *
     * @return si está libre(true) o ocupada(false
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    public RoomType getRoomType(){
        return roomType;
    }

    /**
     * Setea el estado de la habitación Libre(true)/Ocupada(false)
     * @param isAvailable
     */
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomType=" + roomType +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
