package com.fas.models.dtos.responses;


import com.fas.models.entities.Assign;
import com.fas.models.entities.Course;
import com.fas.models.entities.Grade;
import com.fas.models.entities.Term;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
public class AssignResponseDTO {


   private UUID id;


   private LocalDateTime createdAt = LocalDateTime.now();
   private LocalDateTime updatedAt = LocalDateTime.now();

   private boolean isDeleted = false;

   private List<String> weekdays = new ArrayList<>();


   private Grade grade;


   private Course course;


   private Term term;




   public AssignResponseDTO(Assign assign) {
       this.id = assign.getId();
       this.createdAt = assign.getCreatedAt();
       this.updatedAt = assign.getUpdatedAt();
       this.weekdays = assign.getWeekdays();
       this.isDeleted = assign.isDeleted();
       this.grade = assign.getGrade();
       this.course = assign.getCourse();
       this.term = assign.getTerm();
   }
}
