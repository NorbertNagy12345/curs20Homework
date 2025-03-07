package org.fasttrackit.curs20;


import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs20.model.ClimateUnite;
import org.fasttrackit.curs20.model.EventSensor;
import org.fasttrackit.curs20.model.Room;
import org.fasttrackit.curs20.model.SmartLight;
import org.fasttrackit.curs20.repository.RoomRepository;
import org.fasttrackit.curs20.service.SensorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@EnableScheduling
@Component
@RequiredArgsConstructor
public class CommandRunner implements CommandLineRunner {
    private final RoomRepository roomRepository;

    @Override
    public void run(String... args) {
        List<Room> rooms = roomRepository.saveAll(List.of(
                Room.builder()
                        .name("Kitchen")
                        .sizeInSquareMeter(25)
                        .airQualityInPM(5)
                        .humidity(60)
                        .temperature(22)
                        .smartLight(
                                 SmartLight.builder()
                                         .state(true)
                                         .intensityInLumen(750)
                                         .lightTemperatureInKelvin(5000)
                                         .build())
                        .eventSensor(EventSensor.builder()
                                .floodDetector(false)
                                .gasDetector(false)
                                .smokeSensor(false)
                                .build()
                        )
                        .climateUnite(ClimateUnite.builder()
                                .state(false)
                                .setTemperature(22)
                                .maintenance(false)
                                .build())
                        .build(),
                Room.builder()
                        .name("BedRoom")
                        .sizeInSquareMeter(35)
                        .airQualityInPM(5)
                        .humidity(60)
                        .temperature(22)
                        .smartLight(
                                SmartLight.builder()
                                        .state(false)
                                        .intensityInLumen(750)
                                        .lightTemperatureInKelvin(5000)
                                        .build())
                        .eventSensor(EventSensor.builder()
                                .floodDetector(false)
                                .gasDetector(false)
                                .smokeSensor(false)
                                        .build()
                                )
                        .climateUnite(ClimateUnite.builder()
                                .state(false)
                                .setTemperature(22)
                                .maintenance(false)
                                .build())
                        .build()
        ));

    }
}