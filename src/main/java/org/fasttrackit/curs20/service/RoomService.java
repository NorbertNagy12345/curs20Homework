package org.fasttrackit.curs20.service;

import org.fasttrackit.curs20.exceptions.ResourceNotFoundException;
import org.fasttrackit.curs20.model.Room;
import org.fasttrackit.curs20.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoomService {
    RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomsById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country with id:%s was not found".formatted(id)));
    }

    public Room deleteById(Long id) {
        Room foundRoom = getRoomsById(id);
        roomRepository.deleteById(id);
        return foundRoom;
    }


    public Room addNewRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Long id, Room room) {
        Room foundRoom = getRoomsById(id);
        Room updatedRoom = Room.builder()
                .name(foundRoom.getName())
                .id(foundRoom.getId())
                .sizeInSquareMeter(foundRoom.getSizeInSquareMeter())
                .temperature(foundRoom.getTemperature())
                .smartLights(foundRoom.getSmartLights())
                .build();
        return roomRepository.save(updatedRoom);
    }

}
