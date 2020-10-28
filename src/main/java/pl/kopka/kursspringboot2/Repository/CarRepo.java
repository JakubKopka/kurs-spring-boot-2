package pl.kopka.kursspringboot2.Repository;

import org.springframework.stereotype.Repository;
import pl.kopka.kursspringboot2.Entity.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CarRepo {

    private List<Car> carList;

    public CarRepo() {
        this.carList = new ArrayList<>();
        carList.add(new Car(1L, "Tesla", "model X", "black"));
        carList.add(new Car(2L, "Tesla", "model S", "white"));
        carList.add(new Car(3L, "Tesla", "model 3", "red"));
        carList.add(new Car(4L, "Ferrari", "LaFerrari", "red"));
        carList.add(new Car(5L, "Lamborghini", "Huracan", "green"));
    }


    public List<Car> getAllCars() {
        return this.carList;
    }

    public boolean add(Car newCar) {
        return carList.add(newCar);
    }

    public Optional<Car> findFirstById(long id) {
        return carList.stream().filter(car -> car.getId() == id).findFirst();
    }

    public void remove(Car car) {
        carList.remove(car);
    }

    public List<Car> findCarsByColor(String color) {
        return carList.stream().filter(
                car -> car.getColor().toLowerCase().equals(color.toLowerCase())).collect(Collectors.toList()
        );
    }
}
