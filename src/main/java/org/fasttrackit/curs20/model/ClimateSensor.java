package org.fasttrackit.curs20.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClimateSensor {
    @Column
    private int temperature;
    @Column
    private int humidity;
    @Column
    private int AirQualityInPM;
}
