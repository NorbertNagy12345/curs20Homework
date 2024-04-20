package org.fasttrackit.curs20.service;

import org.fasttrackit.curs20.exceptions.ResourceNotFoundException;
import org.fasttrackit.curs20.model.ClimateUnite;
import org.fasttrackit.curs20.model.EventSensor;
import org.fasttrackit.curs20.model.Room;
import org.fasttrackit.curs20.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
                .orElseThrow(() -> new ResourceNotFoundException("Rooms with id:%s was not found".formatted(id)));
    }

    public Room deleteById(Long id) {
        Room foundRoom = getRoomsById(id);
        roomRepository.deleteById(id);
        return foundRoom;
    }


    public Room addNewRoom(Room room) {
        ClimateUnite climateUnite = new ClimateUnite();
        climateUnite.setSetTemperature(22);
        climateUnite.setState(false);
        climateUnite.setMaintenance(false);
        EventSensor eventSensor = new EventSensor();
        eventSensor.setSmokeSensor(false);
        eventSensor.setGasDetector(false);
        eventSensor.setFloodDetector(false);
        room.setClimateUnite(climateUnite);
        room.setEventSensor(eventSensor);
        room.setHumidity(60);
        room.setAirQualityInPM(5);
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

    public void updateRoomsSensor( List <Room> rooms ) {
        rooms.forEach(room -> roomRepository.save(room));

    }

}
