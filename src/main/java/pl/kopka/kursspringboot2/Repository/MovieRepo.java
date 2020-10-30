package pl.kopka.kursspringboot2.Repository;

import org.springframework.stereotype.Repository;
import pl.kopka.kursspringboot2.Model.Movie;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepo {

    private List<Movie> movies;

    public MovieRepo() {
        this.movies = new ArrayList<>();
        movies.add(new Movie(1L, "Joker", 2019, "Todd Phillips"));
        movies.add(new Movie(2L, "1917", 2019, "Sam Mendes"));
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public boolean addMovie(Movie movie) {
        return this.movies.add(movie);
    }
}
