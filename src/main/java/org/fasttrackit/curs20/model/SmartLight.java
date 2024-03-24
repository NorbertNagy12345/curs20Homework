package org.fasttrackit.curs20.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany
    @JsonIgnore
    private List<org.fasttrackit.curs20.model.Room> rooms;
}
