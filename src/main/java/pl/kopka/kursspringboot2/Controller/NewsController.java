package pl.kopka.kursspringboot2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kopka.kursspringboot2.Client.ClientController;
import pl.kopka.kursspringboot2.Model.Client.NewsApi;
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
    public ResponseEntity<List<News>> getAllNews() {
        List<News> news = newsService.getAll();
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable String id) {
        News news = newsService.getNewsById(id);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> editNews(@RequestBody News news){
        System.out.println("wejscie");
        System.out.println(news);
        if(newsService.editNews(news)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
