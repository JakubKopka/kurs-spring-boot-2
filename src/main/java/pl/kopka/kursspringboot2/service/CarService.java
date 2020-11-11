package pl.kopka.kursspringboot2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kopka.kursspringboot2.dao.CarDaoImp;
import pl.kopka.kursspringboot2.model.Car;

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
        Long id = 1L;
        if(cars.size()>0){
            id = cars.get(cars.size()-1).getId()+1;
        }
        newCar.setId(id);
        return carDaoImp.save(newCar);
    }
}
