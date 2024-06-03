package com.binary.CarShow.services;

import com.binary.CarShow.entities.Owner;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService{
    @Override
    public Owner createOwner(Owner owner) {
        return owner;
    }
}
