package org.fasttrackit.curs20.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private int temperature;
    @Column
    private int humidity;
    @Column
    private int airQualityInPM;
    @Column
    private int sizeInSquareMeter;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private org.fasttrackit.curs20.model.ClimateSensor climateSensor;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private org.fasttrackit.curs20.model.EventSensor eventSensor;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JsonIgnore
    private SmartLight smartLights;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private org.fasttrackit.curs20.model.ClimateUnite climateUnite;
}
