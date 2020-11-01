package pl.kopka.kursspringboot2.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
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
        List<News> news = new ArrayList<>();
        String sql = "select * from news";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        maps.forEach(element -> cars.add(new News(Long.parseLong(element.get("id").toString()), String.valueOf(element.get("mark")),
//                String.valueOf(element.get("model")), String.valueOf(element.get("color")), String.valueOf(element.get("production_date")))));
//        return cars;
        System.out.println(maps);
        return null;
    }

}
