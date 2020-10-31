package pl.kopka.kursspringboot2.Dao;

import pl.kopka.kursspringboot2.Model.Car;

import java.util.List;

public interface CarDao {

    boolean save(Car newCar);

    List<Car> findAll();

    List<Car> filterByProductionDate(String from, String to);
}
