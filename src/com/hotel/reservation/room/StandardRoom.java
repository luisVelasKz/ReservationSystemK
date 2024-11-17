package com.hotel.reservation.room;

/**
 * Clase que determina el comportamiento de una habitación tipo Standard
 */
public class StandardRoom extends Room{

    public StandardRoom(RoomType roomType){
        super(roomType);
    }

    /**
     *
     * @param nights
     * @return
     */
    @Override
    public double calculatePrice(int nights) {
        return roomType.getPricePerNight() * nights;
    }
}
