package com.binary.UsedCarShop.services;

import com.binary.UsedCarShop.entities.Car;
import com.binary.UsedCarShop.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CarServiceImplementation implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Car updateCar(Long id, Car carDetails) {
        Car car = carRepository.findById(id.intValue()).orElse(null);
        if(car!=null){
            car.setBrand(carDetails.getBrand());
            car.setModel(carDetails.getModel());
            car.setColor(carDetails.getColor());
            car.setPrice(carDetails.getPrice());
            car.setAvailable(carDetails.isAvailable());
            return carRepository.save(car);
        }
        return null;
    }

    @Override
    public void deleteCar(Long id) {

        carRepository.deleteById(id.intValue());
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id.intValue());
    }

    @Override
    public List<Car> searchCars(String color, Double price) {
        if (color != null && price != null) {
            return carRepository.findByColorAndPriceLessThanEqual(color, price);
        } else if (color != null) {
            return carRepository.findByColor(color);
        } else if (price != null) {
            return carRepository.findByPriceLessThanEqual(price);
        } else {
            return (List<Car>) carRepository.findAll();
        }
    }
}
