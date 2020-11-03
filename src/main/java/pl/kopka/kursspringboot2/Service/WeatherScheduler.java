package pl.kopka.kursspringboot2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.kopka.kursspringboot2.Client.ApiController;
import pl.kopka.kursspringboot2.Client.Model.WeatherApi;
import pl.kopka.kursspringboot2.Model.Weather;


@Component
public class WeatherScheduler {

    private ApiController apiController;
    private Mapper mapper;
    private WeatherService weatherService;

    @Autowired
    public WeatherScheduler(ApiController apiController, Mapper mapper, WeatherService weatherService) {
        this.apiController = apiController;
        this.mapper = mapper;
        this.weatherService = weatherService;
    }

    //    @Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "0 0 * * * *")
    private void getCurrentWeatherFromApi() {
        Weather weather = mapper.mapToWeather(apiController.getWeatherFromApi());
        weatherService.save(weather);
    }
}
