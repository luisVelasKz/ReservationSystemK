package com.hotel.reservation.room;

// Clase RoomManager
public class RoomManager {
    private final IRoomRepository roomRepository;

    public RoomManager(IRoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room findRoom(String roomNumber) {
        return roomRepository.findRoom(roomNumber);
    }

    public void reserveRoom(Room room) {
        if (room.isAvailable()) {
            room.setAvailable(false);
            System.out.println("Habitación " +  " reservada.");
        } else {
            System.out.println("La habitación " + " no está disponible.");
        }
    }


}

