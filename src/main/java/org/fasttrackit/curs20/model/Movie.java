package org.fasttrackit.curs20.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@With
@Builder(toBuilder = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private int year;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private MovieRating movieRating;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Review> reviews;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private Studio studio;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JsonIgnore
    private List<Actor> actors;
}
