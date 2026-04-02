package spring_pr.com.day21.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring_pr.com.day21.model.Movie;
import spring_pr.com.day21.service.MovieService;
@RestController

@CrossOrigin(origins = "*")
public class MovieController {
    
    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }
    @GetMapping("/movies")
    public List<Movie> getMovieTitles(int page, int size) {
        return service.getMovieTitles(page, size);
    }

    @PostMapping("/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return service.createMovie(movie);
    }

}
