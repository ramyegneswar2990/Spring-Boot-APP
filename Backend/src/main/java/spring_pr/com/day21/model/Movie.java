package spring_pr.com.day21.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String posterUrl;

    @Column(nullable = false)
    private int publishedYear; // PUBLISHED_YEAR

    @Column(nullable = false, unique = true)
    private String title;

    public Movie(String description, String posterUrl, int publishedYear, String title) {
        this.description = description;
        this.posterUrl = posterUrl;
        this.publishedYear = publishedYear;
        this.title = title;
    }

}
