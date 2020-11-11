package pl.kopka.kursspringboot2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kopka.kursspringboot2.client.model.ExchangeRate;
import pl.kopka.kursspringboot2.service.ExchangeRateService;

import java.util.Objects;

@RestController
@RequestMapping("/exchange-rate")
@CrossOrigin
public class ExchangeRateController {


    private ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/{currency}")
    public ResponseEntity<ExchangeRate> getExchangeRate(@PathVariable String currency) {

        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(currency);
        if (exchangeRate != null) {
            return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
