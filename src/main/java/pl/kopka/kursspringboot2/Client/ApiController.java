package pl.kopka.kursspringboot2.Client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.kopka.kursspringboot2.Client.Model.WeatherApi;

@Controller
public class ApiController {
    private RestTemplate restTemplate;

    public ApiController() {
        this.restTemplate = new RestTemplate();
    }

//    @EventListener(ApplicationReadyEvent.class)
    public WeatherApi getWeatherFromApi() {
        WeatherApi weatherApi = restTemplate.exchange("https://api.climacell.co/v3/weather/realtime?lat=52&lon=21&location_id=5fa145" +
                        "111ffc97001a9eeb06&unit_system=si&fields=temp%2Chumidity%2Cwind_speed%2Cwind_direction%2Cbaro_" +
                        "pressure&apikey=635zwMA3TChYj5w9bLskmVWyzlAycqSn",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                WeatherApi.class).getBody();
        System.out.println(weatherApi);
        return weatherApi;
    }
}
