package pl.kopka.kursspringboot2.Dao;

import pl.kopka.kursspringboot2.Model.Client.NewsApi;
import pl.kopka.kursspringboot2.Model.News;

import java.util.List;

public interface NewsDao {

    List<News> findAll();
    void save(News news);

    News getNewsById(String id);

    boolean edit(News news);
}
