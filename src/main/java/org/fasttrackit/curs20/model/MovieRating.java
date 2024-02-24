package org.fasttrackit.curs20.model;

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
public class MovieRating {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int rating;
    @Column
    private String agency;

}
