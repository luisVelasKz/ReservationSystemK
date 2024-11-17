package com.hotel.reservation.room.factories;

import com.hotel.reservation.room.Room;
import com.hotel.reservation.room.RoomType;
import com.hotel.reservation.room.StandardRoom;

/**
 * Factoría que retorna objetos de tipo StandardRoom
 */
public class StandardRoomFactory extends RoomFactory{
    @Override
    public Room create() {
        return new StandardRoom(RoomType.STANDARD);
    }
}
