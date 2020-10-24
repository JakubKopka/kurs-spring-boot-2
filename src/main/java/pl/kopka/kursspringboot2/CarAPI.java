package pl.kopka.kursspringboot2;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarAPI {

    private List<Car> carList;

    public CarAPI() {
        this.carList = new ArrayList<>();
        carList.add(new Car(1L, "Tesla", "model X", "black"));
        carList.add(new Car(2L, "Tesla", "model S", "white"));
        carList.add(new Car(3L, "Tesla", "model 3", "red"));
        carList.add(new Car(4L, "Ferrari", "LaFerrari", "red"));
        carList.add(new Car(5L, "Lamborghini", "Huracan", "green"));
    }

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable long id) {
        Optional<Car> first = this.carList.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<List<Car>> getCarsByColor(@RequestParam String color) {
        List<Car> cars = this.carList.stream().filter(
                car -> car.getColor().toLowerCase().equals(color.toLowerCase())).collect(Collectors.toList()
        );
        if (cars.size() > 0) {
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addCar(@RequestBody Car newCar) {
        if (this.carList.stream().filter(car -> car.getId() == newCar.getId()).findFirst().isPresent()
                || !this.carList.add(newCar)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<?> modCar(@RequestBody Car newCar) {
        Optional<Car> first = this.carList.stream().filter(car -> car.getId() == newCar.getId()).findFirst();
        if (first.isPresent()) {
            this.carList.remove(first);
            this.carList.add(newCar);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> modFieldCar(@PathVariable long id, @RequestBody Map<String, String> changes) {
        Optional<Car> first = this.carList.stream().filter(car -> car.getId() == id).findFirst();

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable long id) {
        Optional<Car> first = this.carList.stream().filter(car -> car.getId() == id).findFirst();
        if (first.isPresent()) {
            this.carList.remove(first.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
