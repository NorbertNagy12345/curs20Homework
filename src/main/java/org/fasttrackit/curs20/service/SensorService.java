package org.fasttrackit.curs20.service;


import org.fasttrackit.curs20.model.Room;
import org.fasttrackit.curs20.repository.RoomRepository;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class SensorService {
    private final ScheduledExecutorService scheduler;
    RoomRepository roomRepository;

    public SensorService() {
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::randomWaterSensorState, 0, 10, TimeUnit.MINUTES);
        scheduler.scheduleAtFixedRate(this::randomSmokeSensorState, 0, 10, TimeUnit.MINUTES);
        scheduler.scheduleAtFixedRate(this::randomGasSensorState, 0, 10, TimeUnit.MINUTES);
    }

    public void stopScheduler() {
        scheduler.shutdown();
    }

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
