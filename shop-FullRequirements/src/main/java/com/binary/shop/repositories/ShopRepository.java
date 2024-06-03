package com.binary.shop.repositories;

import com.binary.shop.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

    //count() --> returns the number of entities
    //findALL() --> returns all items of given type
    //findById() --> returns one item by id
    //delete(T entity) --> delete an entity
    //deleteAll() - deletes all the entities in the repository
    //save (T entity) - saves an entity
    //saveAll(); -- saves all the entities
}
