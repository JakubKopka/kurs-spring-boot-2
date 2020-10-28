package pl.kopka.kursspringboot2.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kopka.kursspringboot2.Entity.Car;
import pl.kopka.kursspringboot2.Service.CarService;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable long id) {
        return carService.getCarById(id);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Car>> getCarsByColor(@RequestParam String color) {
        return carService.getCarsByColor(color);
    }

    @PostMapping
    public ResponseEntity<?> addCar(@RequestBody Car newCar) {
        return carService.addCar(newCar);
    }

    @PutMapping
    public ResponseEntity<?> modCar(@RequestBody Car newCar) {
        return carService.modCar(newCar);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> modFieldCar(@PathVariable long id, @RequestBody Map<String, String> changes) {
        return carService.modFieldCar(id, changes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable long id) {
        return carService.deleteCar(id);
    }

}
