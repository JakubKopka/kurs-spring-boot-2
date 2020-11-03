package pl.kopka.kursspringboot2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kopka.kursspringboot2.Model.Weather;
import pl.kopka.kursspringboot2.Repository.WeatherRepo;

import java.util.List;

@Service
public class WeatherService {


    private WeatherRepo weatherRepo;

    @Autowired
    public WeatherService(WeatherRepo weatherRepo) {
        this.weatherRepo = weatherRepo;
    }

    public List<Weather> getAll() {
        return weatherRepo.findAll();
    }

    public void save(Weather weather){
        weatherRepo.save(weather);
    }
}
