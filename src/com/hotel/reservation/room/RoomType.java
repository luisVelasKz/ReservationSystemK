package com.hotel.reservation.room;

/**
 * Enum que define el tipo de habitación que ofrece el hotel y costo por noche
 */
public enum RoomType {
    STANDARD(100),
    DOUBLE(200),
    PRESIDENTIAL(350);

    private final double pricePerNight;

    private RoomType(double pricePerNight){
        this.pricePerNight = pricePerNight;
    }

    public double getPricePerNight(){
        return  pricePerNight;
    }


}
