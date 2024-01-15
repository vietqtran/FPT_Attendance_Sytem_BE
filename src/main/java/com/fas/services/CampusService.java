package com.fas.services;

import com.fas.models.entities.Campus;
import com.fas.models.enums.CampusName;

import java.util.List;

public interface CampusService {
    public Campus findByCampusName(CampusName name);

    public List<Campus> findAllCampuses();

    public Campus findByCampusId(Long campusId);
}
