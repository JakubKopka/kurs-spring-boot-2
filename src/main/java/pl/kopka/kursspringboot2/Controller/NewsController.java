package pl.kopka.kursspringboot2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kopka.kursspringboot2.Client.ClientController;
import pl.kopka.kursspringboot2.Model.News;
import pl.kopka.kursspringboot2.Service.NewsService;

import java.util.List;

@RestController
@RequestMapping("/news")
@CrossOrigin
public class NewsController {

    private NewsService newsService;

    @Autowired
    ClientController clientController;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    @GetMapping
    public ResponseEntity<List<News>> getCars() {
        List<News> news = clientController.getNewsFormApi();
        return new ResponseEntity<>(news, HttpStatus.OK);
    }



}
