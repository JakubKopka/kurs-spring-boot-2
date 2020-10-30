package pl.kopka.kursspringboot2.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kopka.kursspringboot2.Aspect.MovieAnnotation;
import pl.kopka.kursspringboot2.Model.Movie;
import pl.kopka.kursspringboot2.Service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies () {
        List<Movie> movies = movieService.getMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping
    @MovieAnnotation
    public ResponseEntity<?> addMovie(@RequestBody Movie movie){
        if(movieService.addMovie(movie)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
