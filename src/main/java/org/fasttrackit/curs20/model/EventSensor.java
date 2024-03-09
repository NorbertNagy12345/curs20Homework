package org.fasttrackit.curs20.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

}
