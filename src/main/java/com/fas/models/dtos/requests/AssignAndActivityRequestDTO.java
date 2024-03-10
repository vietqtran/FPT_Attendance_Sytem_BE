package com.fas.models.dtos.requests;

public class AssignAndActivityRequestDTO {
    private AssignRequestDTO assignRequestDTO;
    private ActivityRequestDTO activityRequestDTO;

    // constructors, getters, setters

    public AssignRequestDTO getAssignRequestDTO() {
        return assignRequestDTO;
    }

    public void setAssignRequestDTO(AssignRequestDTO assignRequestDTO) {
        this.assignRequestDTO = assignRequestDTO;
    }

    public ActivityRequestDTO getActivityRequestDTO() {
        return activityRequestDTO;
    }

    public void setActivityRequestDTO(ActivityRequestDTO activityRequestDTO) {
        this.activityRequestDTO = activityRequestDTO;
    }
}
