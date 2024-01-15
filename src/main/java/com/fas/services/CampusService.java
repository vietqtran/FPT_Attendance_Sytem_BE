package com.fas.services;

import com.fas.models.entities.Campus;
import com.fas.models.enums.CampusName;

import java.util.List;

public interface CampusService {
    public Campus findByCampusName(CampusName name);

    public Campus findByCampusId(Long campusId);

    public List<Campus> findAllCampuses();
<<<<<<< HEAD

=======
>>>>>>> e4d46b728b32ac82f4c1328de381568502a555dc
}
