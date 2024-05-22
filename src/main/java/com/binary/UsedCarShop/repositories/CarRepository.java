package com.binary.UsedCarShop.repositories;

import com.binary.UsedCarShop.entities.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {
    List<Car> findByColor(String color);
    List<Car> findByColorAndPriceLessThanEqual(String color, double price);
    List<Car> findByPriceLessThanEqual(double price);
    //count() --> returns the number of entities
    //findALL() --> returns all items of given type
    //findById() --> returns one item by id
    //delete(T entity) --> delete an entity
    //deleteAll() - deletes all the entities in the repository
    //save (T entity) - saves an entity
    //saveAll(); -- saves all the entities
}
