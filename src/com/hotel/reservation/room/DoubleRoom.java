package com.hotel.reservation.room;

/**
 * Clase que determina el comportamiento de una habitación tipo Double
 */
public class DoubleRoom extends Room{

    public DoubleRoom(RoomType roomType){
        super(roomType);
    }

    @Override
    public double calculatePrice(int nights) {
        //Descuento del 10% si se queda más de 3 días
        return roomType.getPricePerNight() * nights * (nights > 3 ? 0.9: 1);
    }
}
