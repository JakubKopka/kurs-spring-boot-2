package pl.kopka.kursspringboot2.Dao;

import pl.kopka.kursspringboot2.Model.News;

import java.util.List;

public interface NewsDao {

    List<News> findAll();

}
