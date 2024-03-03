package org.fasttrackit.curs20;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs20.model.ClimateSensor;
import org.fasttrackit.curs20.model.ClimateUnite;
import org.fasttrackit.curs20.model.Room;
import org.fasttrackit.curs20.model.SmartLight;
import org.fasttrackit.curs20.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandRunner implements CommandLineRunner {
    private final RoomRepository roomRepository;

    @Override
    public void run(String... args) {
        roomRepository.saveAll(List.of(
                        Room.builder()
                                .name("Kitchen")
                                .sizeInSquareMeter(25)
                                .smartLights(List.of(
                                        SmartLight.builder()
                                                .id(1L)
                                                .state(true)
                                                .intensityInLumen(700)
                                                .lightTemperatureInKelvin(5000)
                                                .build(),
                                        SmartLight.builder()
                                                .id(2L)
                                                .state(true)
                                                .intensityInLumen(700)
                                                .lightTemperatureInKelvin(5000)
                                                .build()))
                                .climateSensor(ClimateSensor.builder()
                                        .airQualityInPM(5)
                                        .humidity(60)
                                        .temperature(22)
                                        .build())
                                .climateUnite(ClimateUnite.builder()
                                        .state(false)
                                        .setTemperature(22)
                                        .maintenance(false)
                                        .id(1L)
                                        .build())
                                .build()
                        ,
                        Room.builder()
                                .name("BedRoom")
                                .sizeInSquareMeter(35)
                                .smartLights(List.of(
                                        SmartLight.builder()
                                                .id(1L)
                                                .state(true)
                                                .intensityInLumen(700)
                                                .lightTemperatureInKelvin(5000)
                                                .build(),
                                        SmartLight.builder()
                                                .id(2L)
                                                .state(true)
                                                .intensityInLumen(700)
                                                .lightTemperatureInKelvin(5000)
                                                .build()))
                                .climateSensor(ClimateSensor.builder()
                                        .airQualityInPM(5)
                                        .humidity(60)
                                        .temperature(22)
                                        .build())
                                .climateUnite(ClimateUnite.builder()
                                        .state(false)
                                        .setTemperature(22)
                                        .maintenance(false)
                                        .id(1L)
                                        .build()
                                )
                                .build()
                )
        );


    }
}
