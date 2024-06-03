package com.binary.CarShow.repositories;

import com.binary.CarShow.entities.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

    //count() --> returns the number of entities
    //findALL() --> returns all items of given type
    //findById() --> returns one item by id
    //delete(T entity) --> delete an entity
    //deleteAll() - deletes all the entities in the repository
    //save (T entity) - saves an entity
    //saveAll(); -- saves all the entities
}
