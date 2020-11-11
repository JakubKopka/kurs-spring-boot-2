package pl.kopka.kursspringboot2.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.kopka.kursspringboot2.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CarDaoImp implements CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean save(Car car) {
        String sql = "insert into cars values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getId(), car.getMark(), car.getModel(),
                car.getColor(), car.getProductionDate());
        return true;
    }

    @Override
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        String sql = "select * from cars";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(element -> cars.add(new Car(Long.parseLong(element.get("id").toString()), String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")), String.valueOf(element.get("color")), String.valueOf(element.get("production_date")))));
        return cars;
    }

    @Override
    public List<Car> filterByProductionDate(String from, String to) {
        List<Car> cars = new ArrayList<>();
        String sql = "select  * from cars where cars.production_date between ? and ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, from, to);
        maps.forEach(element -> cars.add(new Car(Long.parseLong(element.get("id").toString()), String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")), String.valueOf(element.get("color")), String.valueOf(element.get("production_date")))));
        return cars;
    }
}
