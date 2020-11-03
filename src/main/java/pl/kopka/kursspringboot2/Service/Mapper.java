package pl.kopka.kursspringboot2.Service;

import org.springframework.stereotype.Service;
import pl.kopka.kursspringboot2.Client.Model.WeatherApi;
import pl.kopka.kursspringboot2.Model.Weather;

@Service
public class Mapper {

    public Weather mapToWeather(WeatherApi weatherApi){
        Weather weather = new Weather();
        weather.setTemp(weatherApi.getTemp().getValue());
        weather.setHumidity(weatherApi.getHumidity().getValue());
        weather.setPressure(weatherApi.getBaroPressure().getValue());
        weather.setWindSpeed(weatherApi.getWindSpeed().getValue());
        weather.setWindDirection(weatherApi.getWindDirection().getValue());
        weather.setObservationTime(weatherApi.getObservationTime().getValue());
        return weather;
    }
}
