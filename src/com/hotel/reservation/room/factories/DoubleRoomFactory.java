package com.hotel.reservation.room.factories;

import com.hotel.reservation.room.DoubleRoom;
import com.hotel.reservation.room.Room;
import com.hotel.reservation.room.RoomType;

/**
 * Factoría que retorna objetos de tipo RoomFactory
 */
public class DoubleRoomFactory extends RoomFactory{
    @Override
    public Room create() {
        return new DoubleRoom(RoomType.DOUBLE);
    }
}
