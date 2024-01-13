package com.fas.services.implementation;

import com.fas.models.entities.Campus;
import com.fas.models.enums.CampusName;
import com.fas.models.exceptions.CampusExceptions;
import com.fas.repositories.CampusRepository;
import com.fas.services.CampusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CampusServiceImplementation implements CampusService {
    @Autowired
    private CampusRepository campusRepository;

    @Override
    public Campus findByCampusName(CampusName name) {
        Optional<Campus> campus = campusRepository.findByName(name);
        if(campus.isEmpty()) {
            throw new CampusExceptions("Campus is not existed with name: " + name);
        }
        return campus.get();
    }
}
