package com.hotel.reservation.room.factories;

import com.hotel.reservation.room.PresidentialRoom;
import com.hotel.reservation.room.Room;
import com.hotel.reservation.room.RoomType;

/**
 * Factoría que retorna objetos de tipo PresidentialRoom
 */
public class PresidentialRoomFactory extends RoomFactory{
    @Override
    public Room create() {
        return new PresidentialRoom(RoomType.PRESIDENTIAL);
    }
}
