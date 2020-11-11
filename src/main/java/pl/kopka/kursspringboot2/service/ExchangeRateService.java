package pl.kopka.kursspringboot2.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.kopka.kursspringboot2.client.controller.ClientController;
import pl.kopka.kursspringboot2.client.model.ExchangeRate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class ExchangeRateService {

    private ClientController clientController;

    public ExchangeRateService(ClientController clientController) {
        this.clientController = clientController;
    }

    public ExchangeRate getExchangeRate(String currency) {
        String randomCurrency = getRandomCurrency();
        ResponseEntity<ExchangeRate> exchangeRate = clientController.getExchangeRate(currency.toUpperCase(), randomCurrency);

        if (exchangeRate.getStatusCode() == HttpStatus.OK) {
            ExchangeRate exchange = prepareData(Objects.requireNonNull(exchangeRate.getBody()), randomCurrency);
            return exchange;
        }
        return null;
    }

    private ExchangeRate prepareData(ExchangeRate exchangeRate, String randomCurrency) {
        exchangeRate.getRates().put("value",
                exchangeRate.getRates().get(randomCurrency).setScale(2, BigDecimal.ROUND_HALF_EVEN));
        exchangeRate.getRates().remove(randomCurrency);
        exchangeRate.setFullName(clientController.getFullName(randomCurrency));
        return exchangeRate;
    }

    private String getRandomCurrency() {
        Random rand = new Random();
        List<String> currencyList = Arrays.asList("AUD", "BGN", "BRL", "CAD", "CHF", "CNY", "CZK", "DKK", "EUR",
                "GBP", "HKD", "HRK", "HUF", "IDR", "ILS", "INR", "ISK", "JPY", "KRW", "MXN", "MYR", "NOK", "NZD",
                "PHP", "RON", "RUB", "SEK", "SGD", "THB", "TRY", "USD", "ZAR");
        return currencyList.get(rand.nextInt(currencyList.size()));
    }
}
