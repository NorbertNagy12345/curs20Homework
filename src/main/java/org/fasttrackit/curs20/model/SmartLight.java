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
    @Column
    private int lightTemperatureInKelvin;
    @Column
    private int intensityInLumen;
    @Column
    private boolean state;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Room> room;
}
