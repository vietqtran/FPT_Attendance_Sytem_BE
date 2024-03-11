package com.fas.services.implementation;


import com.fas.models.dtos.requests.ActivityRequestDTO;
import com.fas.models.dtos.requests.AssignRequestDTO;
import com.fas.models.dtos.requests.AttendanceRequestDTO;
import com.fas.models.dtos.responses.ActivityResponseDTO;
import com.fas.models.dtos.responses.AssignResponseDTO;
import com.fas.models.dtos.responses.AttendanceResposeDTO;
import com.fas.models.dtos.responses.SlotResponseDTO;
import com.fas.models.entities.*;
import com.fas.models.exceptions.*;
import com.fas.repositories.*;
import com.fas.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class AssignServiceImplementation implements AssignService {


   @Autowired
   private AssignRepository assignRepository;


   @Autowired
   private ActivityRepository activityRepository;


   @Autowired
   private TermRepository termRepository;
   @Autowired
   private SlotRepository slotRepository;


   @Autowired
   private RoomRepository roomRepository;


   @Autowired
   private InstructorRepository instructorRepository;


   @Autowired
   private GradeRepository gradeRepository;


   @Autowired
   private AttendanceService attendanceService;


   public static List<LocalDate> findDayOfWeekInRange(LocalDate startDate, LocalDate endDate, DayOfWeek dayOfWeek) {
       System.out.println(dayOfWeek);


       List<LocalDate> result = new ArrayList<>();
       LocalDate currentDate = startDate;


       // Lặp qua từng ngày trong khoảng thời gian
       while (!currentDate.isAfter(endDate)) {
           // Kiểm tra xem ngày hiện tại là thứ mấy
           if (currentDate.getDayOfWeek() == dayOfWeek) {
               // Nếu là thứ mà bạn đang tìm kiếm, thêm vào danh sách kết quả
               result.add(currentDate);
           }
           // Tiếp tục với ngày tiếp theo
           currentDate = currentDate.plusDays(1);
       }


       return result;
   }


   @Override
   public AssignResponseDTO createAssign(AssignRequestDTO assignRequestDTO, ActivityRequestDTO activityRequestDTO) {
       List<Activity> activities = activityRepository.findAll();
       Assign assign = assignRequestDTO.getAssign();

       Optional<Term> term = termRepository.findById(assign.getTerm().getId());
       if (term.isEmpty()) {
           throw new TermExceptions("Term not found");
       }

       Assign existedAssign = assignRepository.findByTermIdAndCourseIdAndGradeId(term.get().getId(), assign.getCourse().getId(), assign.getGrade().getId());

       if (existedAssign != null) {
           throw new AssignException("Assign already exists");
       }

       assign.getWeekdays().forEach(weekday -> {
           DayOfWeek dayOfWeek = DayOfWeek.valueOf(weekday);
           List<LocalDate> datesInRange = findDayOfWeekInRange(term.get().getStartAt(), term.get().getEndAt(), dayOfWeek);


           datesInRange.forEach(date -> {
               activities.forEach(activity -> {
                   if (activity.getDate().equals(date)) {
                       Slot slot = slotRepository.findById(activityRequestDTO.getSlotId()).orElseThrow(() -> new SlotExceptions("Slot not found"));
                       if(activity.getSlot().equals(slot)) {
                           Room room = roomRepository.findById(activityRequestDTO.getRoomId()).orElseThrow(() -> new RoomExceptions("Room not found"));
                           Instructor instructor = instructorRepository.findById(activityRequestDTO.getInstructorId()).orElseThrow(() -> new InstructorExceptions("Instructor not found"));
                           if (activity.getRoom().equals(room) || activity.getInstructor().equals(instructor)) {
                               System.out.println("room or instructor");
                               throw new ActivityExceptions("Activity already exists");
                           }
                       }
                   }
               });
           });
       });


       Assign newAssign = assignRepository.save(assign);


       assign.getWeekdays().forEach(weekday -> {
           DayOfWeek dayOfWeek = DayOfWeek.valueOf(weekday);
           List<LocalDate> datesInRange = findDayOfWeekInRange(term.get().getStartAt(), term.get().getEndAt(), dayOfWeek);


           datesInRange.forEach(date -> {
               activityRequestDTO.setAssignId(newAssign.getId());
               Activity activity = activityRequestDTO.getActivity();
               activity.setDate(date);


               Grade grade = gradeRepository.findById(newAssign.getGrade().getId()).orElseThrow(() -> new GradeExceptions("Grade not found"));


               System.out.println(grade.getId());


               grade.getStudents().forEach(student -> {
                 AttendanceRequestDTO attendance = new AttendanceRequestDTO();

                 attendance.setStudentId(student.getId());
                 attendance.setCreateAt(LocalDateTime.now());
                 attendance.setUpdateAt(LocalDateTime.now());
                 attendance.setContent("");

                 Attendance newAttendance = attendanceService.createAttendance(attendance);


                 activity.getAttendances().add(newAttendance);
               });

               activityRepository.save(activity);
           });
       });


       return new AssignResponseDTO(assign);
   }


   @Override
   public List<AssignResponseDTO> getAllAssigns() {
       List<Assign> assigns = assignRepository.findAll();
       List<AssignResponseDTO> list = new ArrayList<>();
       for (Assign assign : assigns) {
           list.add(new AssignResponseDTO(assign));
       }
       return list;
   }


   @Override
   public AssignResponseDTO updateAssign(AssignRequestDTO assignRequestDTO, UUID assignId)  throws AssignException {
       Assign existedAssign = assignRepository.findById(assignId).orElseThrow(() -> new AssignException("Assign not found"));


       existedAssign.setUpdatedAt(LocalDateTime.now());
       existedAssign.setTerm(assignRequestDTO.getAssign().getTerm());
       existedAssign.setCourse(assignRequestDTO.getAssign().getCourse());
       existedAssign.setGrade(assignRequestDTO.getAssign().getGrade());
       existedAssign.setWeekdays(assignRequestDTO.getAssign().getWeekdays());


       return new AssignResponseDTO(assignRepository.save(existedAssign));
   }


   @Override
   public String deleteAssign(UUID id) {
       Assign existedAssign = assignRepository.findById(id).get();
       if (existedAssign == null) {
           throw new BuildingExceptions("Assign not found");
       }
       assignRepository.delete(existedAssign);
       return "Delete successfully";
   }


   @Override
   public AssignResponseDTO getAssignById(UUID id) {
       Assign assign = assignRepository.findById(id).orElseThrow(() -> new AssignException("Assign not found"));;
       if (assign == null) {
           return null;
       }
       return new AssignResponseDTO(assign);
   }
}
