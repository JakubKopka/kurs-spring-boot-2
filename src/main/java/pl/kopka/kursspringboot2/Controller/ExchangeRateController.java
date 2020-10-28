package pl.kopka.kursspringboot2.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kopka.kursspringboot2.Client.ExchangeRate;
import pl.kopka.kursspringboot2.Service.ExchangeRateService;

@RestController
@RequestMapping("/exchange-rate")
@CrossOrigin
public class ExchangeRateController {


    ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/{currency}")
    public ResponseEntity<ExchangeRate> getExchangeRate(@PathVariable String currency) {
        return exchangeRateService.getExchangeRate(currency);
    }
}
