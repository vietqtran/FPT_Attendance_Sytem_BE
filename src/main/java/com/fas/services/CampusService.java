package com.fas.services;

import com.fas.models.entities.Campus;
import com.fas.models.enums.CampusName;

public interface CampusService {
    Campus findByCampusName(CampusName name);
}
