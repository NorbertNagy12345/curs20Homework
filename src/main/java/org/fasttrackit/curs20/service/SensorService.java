package org.fasttrackit.curs20.service;


import org.fasttrackit.curs20.model.Room;


import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class SensorService {
    private final ScheduledExecutorService scheduler;
     org.fasttrackit.curs20.repository.RoomRepository roomRepository;

    public SensorService() {
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::randomWaterSensorState, 0, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::randomSmokeSensorState, 0, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::randomGasSensorState, 0, 1, TimeUnit.SECONDS);
        System.out.println("Sensor state changed");
    }

    public void stopScheduler() {
        scheduler.shutdown();
    }

    public void randomSmokeSensorState() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        System.out.println(randomNum);
        if (randomNum == 2) {
            List<org.fasttrackit.curs20.model.Room> allRooms = roomRepository.findAll();
            allRooms.forEach(r -> r.getEventSensor().setSmokeDetected(true));
            System.out.println("Smoke detected");
        }
    }

    public void randomGasSensorState() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        System.out.println(randomNum);
        if (randomNum == 2) {
            List<org.fasttrackit.curs20.model.Room> allRooms = roomRepository.findAll();
            allRooms.forEach(r -> r.getEventSensor().setGasDetector(true));
            System.out.println("Gas detected");
        }
    }

    public void randomWaterSensorState() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        System.out.println(randomNum);
        if (randomNum == 2) {
            List<org.fasttrackit.curs20.model.Room> allRooms = roomRepository.findAll();
            allRooms.forEach(r -> r.getEventSensor().setFloodDetector(true));
            System.out.println("Flood detected");
        }
    }
}
