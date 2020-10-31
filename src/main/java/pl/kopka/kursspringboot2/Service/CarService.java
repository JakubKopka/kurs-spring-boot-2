package pl.kopka.kursspringboot2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kopka.kursspringboot2.Dao.CarDaoImp;
import pl.kopka.kursspringboot2.Model.Car;

import java.util.List;

@Service
public class CarService {

    private CarDaoImp carDaoImp;

    @Autowired
    public CarService(CarDaoImp carDaoImp) {
        this.carDaoImp = carDaoImp;
    }

    public List<Car> getAll() {
        return carDaoImp.findAll();
    }

    public List<Car> getFilter(String from, String to) {
        return carDaoImp.filterByProductionDate(from, to);
    }

    public boolean addCar(Car newCar) {
        List<Car> cars = getAll();
        System.out.println(cars.get(cars.size()-1).getId());
        newCar.setId(cars.get(cars.size()-1).getId()+1);
        return carDaoImp.save(newCar);
    }
}
