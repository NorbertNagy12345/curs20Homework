package org.fasttrackit.curs20.model;

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
public class EventSensor {
    @Id
    @GeneratedValue
    private Long id;
    private boolean smokeSensor;
    private boolean gasDetector;
    private boolean floodDetector;


    public void setSmokeDetected(boolean b) {
        this.smokeSensor = b;
    }
}
