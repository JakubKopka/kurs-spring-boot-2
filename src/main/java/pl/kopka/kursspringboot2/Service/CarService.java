package pl.kopka.kursspringboot2.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.kopka.kursspringboot2.Entity.Car;
import pl.kopka.kursspringboot2.Repository.CarRepo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CarService {

    private CarRepo carRepo;

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public ResponseEntity<Car> getCarById(long id) {
        Optional<Car> first = carRepo.getAllCars().stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carRepo.getAllCars(), HttpStatus.OK);
    }

    public ResponseEntity<List<Car>> getCarsByColor(String color) {
        List<Car> cars = carRepo.findCarsByColor(color);
        if (cars.size() > 0) {
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> addCar(Car newCar) {
        List<Car> cars = carRepo.getAllCars();
        newCar.setId(cars.get(cars.size() - 1).getId() + 1);
        if (carRepo.add(newCar)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    public ResponseEntity<?> modCar(Car newCar) {
        Optional<Car> first = carRepo.findFirstById(newCar.getId());
        if (first.isPresent()) {
            carRepo.remove(first.get());
            carRepo.add(newCar);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> modFieldCar(long id, Map<String, String> changes) {
        Optional<Car> first = carRepo.findFirstById(id);
        if (first.isPresent()) {
            changes.forEach((change, value) -> {
                switch (change) {
                    case "mark":
                        first.get().setMark(value);
                        break;
                    case "model":
                        first.get().setModel(value);
                        break;
                    case "color":
                        first.get().setColor(value);
                        break;
                }
            });
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<?> deleteCar(long id) {
        Optional<Car> first = carRepo.findFirstById(id);
        if (first.isPresent()) {
            carRepo.remove(first.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
