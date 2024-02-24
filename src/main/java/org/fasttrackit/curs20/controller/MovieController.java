package org.fasttrackit.curs20.controller;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.curs20.model.Movie;
import org.fasttrackit.curs20.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<Movie> getAll(Movie movie){
        return movieService.getAllMovies();
    }
}
