package com.hotel.reservation.room;

// Interfaz para la gestión de habitaciones
public interface IRoomRepository {
    Room findRoom(String roomNumber);
    void addRoom(Room room);
    void removeRoom(Room room);
}
