package org.fasttrackit.curs20.service;


import org.fasttrackit.curs20.model.Room;
import org.fasttrackit.curs20.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
@Service
public class SensorService {
    private final ScheduledExecutorService scheduler;
@Autowired
    RoomService roomService;


    public SensorService() {
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::randomWaterSensorState, 1, 1, TimeUnit.MINUTES);
        scheduler.scheduleAtFixedRate(this::randomSmokeSensorState, 2, 1, TimeUnit.MINUTES);
        scheduler.scheduleAtFixedRate(this::randomGasSensorState, 3, 1, TimeUnit.MINUTES);
        System.out.println("Sensor state changed");
    }

    public void stopScheduler() {
        scheduler.shutdown();
    }

    public void randomSmokeSensorState() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        System.out.println(randomNum);
        if (randomNum == 2) {
            List<Room> allRooms = roomService.getAllRooms();
            allRooms.forEach(r -> r.getEventSensor().setSmokeDetected(true));
            System.out.println("Smoke detected");
            roomService.updateRoomsSensor(allRooms);
        }
    }

    public void randomGasSensorState() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        System.out.println(randomNum);
        if (randomNum == 2) {
            List<Room> allRooms = roomService.getAllRooms();
            allRooms.forEach(r -> r.getEventSensor().setGasDetector(true));
            System.out.println("Gas detected");
            roomService.updateRoomsSensor(allRooms);
        }
    }

    public void randomWaterSensorState() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        System.out.println(randomNum);
        if (randomNum == 2) {
            List<Room> allRooms = roomService.getAllRooms();
            allRooms.forEach(r -> r.getEventSensor().setFloodDetector(true));
            System.out.println("Flood detected");
            roomService.updateRoomsSensor(allRooms);
        }
    }
}
