package com.binary.UsedCarShop.services;

import com.binary.UsedCarShop.entities.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface CarService {
    public Car addCar(Car car);
    public List<Car> getAllCars();
    public Car updateCar(Long id, Car carDetails);
    public void deleteCar(Long id);
    public Optional<Car> getCarById(Long id);
    public List<Car> searchCars(String color, Double price);

}
