package pl.kopka.kursspringboot2.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.kopka.kursspringboot2.Model.Client.NewsApi;
import pl.kopka.kursspringboot2.Model.News;

import java.sql.ResultSet;
import java.sql.SQLException;
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

    @Override
    public News getNewsById(String id) {
        String sql = "select * from news where id = ?";
        News news = jdbcTemplate.queryForObject(sql, new RowMapper<News>() {
            @Override
            public News mapRow(ResultSet resultSet, int i) throws SQLException {
                return new News(resultSet.getString("id"), resultSet.getString("title"),
                        resultSet.getString("description"), resultSet.getString("url"),
                        resultSet.getString("author"), resultSet.getString("image"),
                        resultSet.getString("published"));
            }
        }, id);
        return news;
    }

    @Override
    public boolean edit(News news) {
        String sql = "update news set title=?, description=?, url=?, author=?, image=?, published=? where id=?";
        jdbcTemplate.update(sql, news.getTitle(), news.getDescription(),
                news.getUrl(), news.getAuthor(), news.getImage(), news.getPublished(),  news.getId() );
        return true;
    }

}
