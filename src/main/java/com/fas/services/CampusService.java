package com.fas.services;

import com.fas.models.entities.Campus;
import com.fas.models.enums.CampusName;

import java.util.List;


<<<<<<< HEAD
    List<Campus> findAllCampuses();

    public Campus findByCampusId(Long campusId);
=======

public interface CampusService {
    public Campus findByCampusName(CampusName name);

    public Campus findByCampusId(Long campusId);

    public List<Campus> findAllCampuses();
>>>>>>> 5706112d3f6a53b2e3d68aed3f81d32fede050fa
}
