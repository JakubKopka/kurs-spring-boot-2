package pl.kopka.kursspringboot2.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.kopka.kursspringboot2.Model.Client.NewsApi;
import pl.kopka.kursspringboot2.Model.News;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class NewsDaoImp implements NewsDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<News> findAll() {
        List<News> newsList = new ArrayList<>();
        String sql = "select * from news";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(element -> newsList.add(new News(element.get("id").toString(), String.valueOf(element.get("title")),
                String.valueOf(element.get("description")), String.valueOf(element.get("url")), String.valueOf(element.get("author")),
                String.valueOf(element.get("image")), String.valueOf(element.get("published")))));
        return newsList;
    }

    @Override
    public void save(News news) {
        String sql = "insert into news values (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, news.getId(), news.getTitle(), news.getDescription(),
                news.getUrl(), news.getAuthor(), news.getImage(), news.getPublished());
    }

}
