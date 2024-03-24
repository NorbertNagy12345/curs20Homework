package org.fasttrackit.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ClimateSensor extends org.fasttrackit.curs20.model.Room {
    @Id
    private Long id;
}
