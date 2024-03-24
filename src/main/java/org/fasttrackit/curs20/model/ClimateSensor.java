package org.fasttrackit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @Id
    @GeneratedValue
    private Long id;
    private int temperature;
    private int humidity;
    private int airQualityInPM;
}
