package pl.kopka.kursspringboot2.Client;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import org.springframework.stereotype.Controller;


@Controller
public class ClientController {

    private RestTemplate restTemplate;

    public ClientController() {
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<ExchangeRate> getExchangeRate(String from, String to) {
        return restTemplate.exchange("https://api.frankfurter.app/latest?from=" + from + "&to=" + to,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                ExchangeRate.class);
    }

    public String getFullName(String randomCurrency) {
        JsonNode image = Objects.requireNonNull(restTemplate
                .getForObject("https://api.frankfurter.app/currencies", JsonNode.class)).get(randomCurrency);
        return image.asText();
    }
}
