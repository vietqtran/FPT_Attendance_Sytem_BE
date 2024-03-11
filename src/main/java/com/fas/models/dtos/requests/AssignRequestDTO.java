package com.fas.models.dtos.requests;




import com.fas.models.entities.*;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
public class AssignRequestDTO {


   private UUID id;


   private LocalDateTime createdAt = LocalDateTime.now();
   private LocalDateTime updatedAt = LocalDateTime.now();

   private boolean isDeleted = false;


   private List<String> weekdays = new ArrayList<>();


   private UUID gradeId;


   private UUID courseId;


   private UUID termId;


   public Assign getAssign() {
       return new Assign(id, createdAt, updatedAt,isDeleted, weekdays, gradeId, courseId, termId);
   }
}
