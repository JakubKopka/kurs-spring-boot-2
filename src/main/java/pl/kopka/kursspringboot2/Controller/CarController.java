package pl.kopka.kursspringboot2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kopka.kursspringboot2.Model.Car;
import pl.kopka.kursspringboot2.Service.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        List<Car> cars = carService.getAll();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Car>> getFilterCars(@RequestParam(value = "from", required = false, defaultValue = "1900-01-01") String from,
                                                   @RequestParam(value = "to", required = false, defaultValue = "2200-01-01") String to) {
        List<Car> cars = carService.getFilter(from, to);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCar(@RequestBody Car newCar) {
        if (carService.addCar(newCar)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
