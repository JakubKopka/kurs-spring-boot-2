package pl.kopka.kursspringboot2.Client;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.kopka.kursspringboot2.Model.News;
import pl.kopka.kursspringboot2.Model.NewsApi;

import java.util.Arrays;
import java.util.List;

@Controller
public class ClientController {

    private RestTemplate restTemplate;

    public ClientController() {
        this.restTemplate = new RestTemplate();
    }

    public List<News> getNewsFormApi() {
        NewsApi newsApi = restTemplate.exchange("https://api.currentsapi.services/v1/latest-news?apiKey=SV-X6xkwFnZLcUnghDlFOFGtE1aSUqaxb2OuI2kM_OgAvwRv",
                HttpMethod.GET,
                HttpEntity.EMPTY,
                NewsApi.class).getBody();
        return newsApi.getNews();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void saveNewsToDatabase(){
        getNewsFormApi().stream().forEach(element ->{

        });
    }


}
