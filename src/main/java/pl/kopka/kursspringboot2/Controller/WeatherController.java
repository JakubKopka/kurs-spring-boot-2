package pl.kopka.kursspringboot2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kopka.kursspringboot2.Model.Weather;
import pl.kopka.kursspringboot2.Service.WeatherService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public ResponseEntity<List<Weather>> getAll(){
        return new ResponseEntity<>(weatherService.getAll(), HttpStatus.OK);
    }

}
