package com.binary.CarShow.services;

import com.binary.CarShow.entities.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {

    public Owner createOwner(Owner owner);

}
