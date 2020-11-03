package pl.kopka.kursspringboot2.Client;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.kopka.kursspringboot2.Client.Model.WeatherApi;

import java.util.Collections;

@Controller
public class ApiController {
    private RestTemplate restTemplate;

    public ApiController() {
        this.restTemplate = new RestTemplate();
    }

    public WeatherApi getWeatherFromApi() {
        String url = "https://api.climacell.co/v3/weather/realtime?lat=52.1&lon=21.1&location_id=5fa145111ffc97001a9eeb06&unit_system=si&fields=temp,humidity,baro_pressure,wind_speed,wind_direction&apikey=635zwMA3TChYj5w9bLskmVWyzlAycqSn";
        WeatherApi weatherApi = restTemplate.exchange(url,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                WeatherApi.class).getBody();
//        System.out.println(weatherApi);
        return weatherApi;
    }
}
