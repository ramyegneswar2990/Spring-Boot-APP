package spring_pr.com.day21.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring_pr.com.day21.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    
}
