package spring_pr.com.day21.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import spring_pr.com.day21.model.Movie;
import spring_pr.com.day21.repository.MovieRepository;

@Service
public class MovieService {
    private final MovieRepository Repository;

    public MovieService(MovieRepository Repository) {
        this.Repository = Repository;
    }

    public List<Movie> getMovieTitles(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("title").descending());
        return Repository.findAll(pageRequest).getContent();
    }

    public Movie createMovie(Movie movie) {
       //movie = new Movie(movie.getDescription(), movie.getPosterUrl(), movie.getPublishedYear(), movie.getTitle());
        return Repository.save(movie);
    }

}
