package com.fas.models.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assign {


   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private UUID id;


   private LocalDateTime createdAt = LocalDateTime.now();
   private LocalDateTime updatedAt = LocalDateTime.now();


   @ElementCollection
   private List<String> weekdays = new ArrayList<>();


   @ManyToOne
   @JsonIgnore
   private Grade grade;


   @ManyToOne
   @JsonIgnore
   private Course course;


   @JsonIgnore
   @ManyToOne
   private Term term;


   public Assign(UUID assignId) {
       this.id = assignId;
   }


   public Assign(UUID id, LocalDateTime createdAt, LocalDateTime updatedAt, List<String> weekdays, UUID gradeId, UUID courseId, UUID termId) {
       this.id = id;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
       this.weekdays = weekdays;
       this.grade = new Grade(gradeId);
       this.course = new Course(courseId);
       this.term = new Term(termId);
   }
}
