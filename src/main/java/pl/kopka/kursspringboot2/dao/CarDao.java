package pl.kopka.kursspringboot2.dao;

import pl.kopka.kursspringboot2.model.Car;

import java.util.List;

public interface CarDao {

    boolean save(Car newCar);

    List<Car> findAll();

    List<Car> filterByProductionDate(String from, String to);
}
