package org.fasttrackit.curs20;


import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs20.model.SmartLight;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.List;

@EnableScheduling
@Component
@RequiredArgsConstructor
public class CommandRunner implements CommandLineRunner {
    private final org.fasttrackit.curs20.repository.RoomRepository roomRepository;

    @Override
    public void run(String... args) {
        List<org.fasttrackit.curs20.model.Room> rooms = roomRepository.saveAll(List.of(
                org.fasttrackit.curs20.model.Room.builder()
                        .name("Kitchen")
                        .sizeInSquareMeter(25)
                        .airQualityInPM(5)
                        .humidity(60)
                        .temperature(22)
                        .smartLights(
                                SmartLight.builder()
                                        .state(true)
                                        .intensityInLumen(700)
                                        .lightTemperatureInKelvin(5000)
                                        .build())
                        .smartLights(
                                SmartLight.builder()
                                        .state(true)
                                        .intensityInLumen(700)
                                        .lightTemperatureInKelvin(5000)
                                        .build()
                        )
                        .climateUnite(org.fasttrackit.curs20.model.ClimateUnite.builder()
                                .state(false)
                                .setTemperature(22)
                                .maintenance(false)
                                .build())
                        .build(),
                org.fasttrackit.curs20.model.Room.builder()
                        .name("BedRoom")
                        .sizeInSquareMeter(35)
                        .airQualityInPM(5)
                        .humidity(60)
                        .temperature(22)
                        .smartLights(
                                SmartLight.builder()
                                        .state(true)
                                        .intensityInLumen(700)
                                        .lightTemperatureInKelvin(5000)
                                        .build())
                        .smartLights(
                                SmartLight.builder()
                                        .state(true)
                                        .intensityInLumen(700)
                                        .lightTemperatureInKelvin(5000)
                                        .build()
                        )
                        .climateUnite(org.fasttrackit.curs20.model.ClimateUnite.builder()
                                .state(false)
                                .setTemperature(22)
                                .maintenance(false)
                                .build())
                        .build()
        ));
    }

    public void random() {

    }
}