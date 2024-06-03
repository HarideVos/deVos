package com.binary.CarShow.repositories;

import com.binary.CarShow.entities.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
