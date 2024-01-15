package com.fas.services;

import com.fas.models.entities.Campus;
import com.fas.models.enums.CampusName;

import java.util.List;

public interface CampusService {
    Campus findByCampusName(CampusName name);

    List<Campus> findAllCampuses();
}
