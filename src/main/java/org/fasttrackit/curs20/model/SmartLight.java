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
public class SmartLight {
    @Id
    @GeneratedValue
    private Long id;
    private int lightTemperatureInKelvin;
    private int intensityInLumen;
    private boolean state;

}
