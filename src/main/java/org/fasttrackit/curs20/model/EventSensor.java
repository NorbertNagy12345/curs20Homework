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
public class EventSensor {
    @Column
    private boolean smokeSensor;
    @Column
    private boolean gazDetector;
    @Column
    private boolean floodDetector;
}
