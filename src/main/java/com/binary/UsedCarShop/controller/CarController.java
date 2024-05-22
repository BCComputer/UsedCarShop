package com.binary.UsedCarShop.controller;

import com.binary.UsedCarShop.entities.Car;
import com.binary.UsedCarShop.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
    @Autowired
    private CarService carService;

    //http://localhost:8080/api/v1/car/car_list
    @GetMapping("/car_list")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/car/1
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Car>> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/car/add
    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.addCar(car), HttpStatus.CREATED);
    }

    // http://localhost:8080/api/v1/car/update/12
    @PutMapping("/update/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        return new ResponseEntity<>(carService.updateCar(id, carDetails), HttpStatus.CREATED);
    }

    //http://localhost:8080/api/v1/car/delete/12
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8080/api/v1/car/search?color=silver
    @GetMapping("/search")
    public ResponseEntity<List<Car>> searchCars(@RequestParam(required = false) String color,
                                                @RequestParam(required = false) Double price) {
        return new ResponseEntity<>(carService.searchCars(color, price), HttpStatus.OK);
    }
}
