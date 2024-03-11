package com.fas.repositories;

import com.fas.models.entities.Activity;
import com.fas.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {

    List<Activity> findByAttendances_StudentAndDateIn(Student student, List<LocalDate> weekdays);

    List<Activity> findByAssignId(UUID assignId);
}
