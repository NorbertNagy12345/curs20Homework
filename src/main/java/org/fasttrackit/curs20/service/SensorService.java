package org.fasttrackit.curs20.service;


import org.fasttrackit.curs20.model.Room;
import org.fasttrackit.curs20.repository.RoomRepository;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SensorService {
    RoomRepository roomRepository;

    public void randomSmokeSensorState() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        if (randomNum == 2) {
            List<Room> allRooms = roomRepository.findAll();
            allRooms.forEach(r -> r.getEventSensor().setSmokeDetected(true));
        }
    }

    public void randomGasSensorState() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        if (randomNum == 2) {
            List<Room> allRooms = roomRepository.findAll();
            allRooms.forEach(r -> r.getEventSensor().setGasDetector(true));
        }
    }

    public void randomWaterSensorState() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        if (randomNum == 2) {
            List<Room> allRooms = roomRepository.findAll();
            allRooms.forEach(r -> r.getEventSensor().setFloodDetector(true));
        }
    }
}
