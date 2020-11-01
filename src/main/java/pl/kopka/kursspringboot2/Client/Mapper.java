package pl.kopka.kursspringboot2.Client;

import org.springframework.stereotype.Component;
import pl.kopka.kursspringboot2.Model.Client.NewsApi;
import pl.kopka.kursspringboot2.Model.News;

@Component
public class Mapper {

    public News mapToNews(NewsApi newsApi){
        News news = new News();
        news.setId(newsApi.getId());
        news.setDescription(newsApi.getDescription());
        news.setTitle(newsApi.getTitle());
        news.setImage(newsApi.getImage());
        news.setUrl(newsApi.getUrl());
        news.setPublished(newsApi.getPublished());
        news.setAuthor(newsApi.getAuthor());
        return news;
    }
}
