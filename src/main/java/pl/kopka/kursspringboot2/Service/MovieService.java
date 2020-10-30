package pl.kopka.kursspringboot2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.kopka.kursspringboot2.Model.Movie;
import pl.kopka.kursspringboot2.Repository.MovieRepo;

import java.util.List;

@Service
public class MovieService {

    private MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<Movie> getMovies() {
        return movieRepo.getMovies();
    }

    public boolean addMovie(Movie movie) {
        return movieRepo.addMovie(movie);
    }
}
