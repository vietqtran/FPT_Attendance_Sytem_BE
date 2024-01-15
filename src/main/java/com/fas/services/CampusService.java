package com.fas.services;

import com.fas.models.entities.Campus;
import com.fas.models.enums.CampusName;

<<<<<<< HEAD
import java.util.List;

public interface CampusService {
    Campus findByCampusName(CampusName name);

    List<Campus> findAllCampuses();
=======
import java.util.UUID;

public interface CampusService {
    public Campus findByCampusName(CampusName name);

    public Campus findByCampusId(Long campusId);
>>>>>>> 0f7f0144a64ad94ec626e3a7422bb34599b8bf69
}
