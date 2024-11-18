package com.hotel.reservation.room;

/**
 * Clase que determina el comportamiento de una habitación tipo Presidential
 */
public class PresidentialRoom extends Room{

    public PresidentialRoom(RoomType roomType) {
        super(roomType);
    }

    @Override
    public double calculatePrice(int nights) {
        //Descuento del 25% si se queda más de 5 días
        return roomType.getPricePerNight() * nights * (nights > 5 ? 0.75:1);
    }
}
