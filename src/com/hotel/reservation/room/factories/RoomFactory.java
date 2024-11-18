package com.hotel.reservation.room.factories;

import com.hotel.reservation.room.Room;
import com.hotel.reservation.room.RoomType;

/**
 * Clase abstracta que define el comportamiento de las factories de habitaciones.
 */
public abstract class RoomFactory {
    /**
     *
     * @return un objeto de tipo Room o que extienda de
     * la clase Room (StandardRoom, DoubleRoom, PresidentialRoom)
     */
    public abstract Room create();
}
