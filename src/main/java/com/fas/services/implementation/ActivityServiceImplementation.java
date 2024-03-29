package com.fas.services.implementation;

import com.fas.models.dtos.requests.ActivityRequestDTO;
import com.fas.models.dtos.responses.ActivityResponseDTO;
import com.fas.models.dtos.responses.AssignResponseDTO;
import com.fas.models.entities.*;
import com.fas.models.exceptions.ActivityExceptions;
import com.fas.repositories.ActivityRepository;
import com.fas.services.ActivityService;
import com.fas.services.AssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ActivityServiceImplementation implements ActivityService {
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

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private AssignService assignService;
    @Override
    public List<ActivityResponseDTO> createActivity(ActivityRequestDTO activityRequestDTO, UUID assignId) {
        AssignResponseDTO assignResponseDTO = assignService.getAssignById(assignId);

        List<ActivityResponseDTO> activities = new ArrayList<>();

        assignResponseDTO.getWeekdays().forEach(weekday -> {
            DayOfWeek dayOfWeek = DayOfWeek.valueOf(weekday);
            List<LocalDate> datesInRange = findDayOfWeekInRange(assignResponseDTO.getTerm().getStartAt(), assignResponseDTO.getTerm().getEndAt(), dayOfWeek);

            datesInRange.forEach(date -> {
                activityRequestDTO.setAssignId(assignId);
                Activity activity = activityRequestDTO.getActivity();
                activities.add(new ActivityResponseDTO(activityRepository.save(activity)));
                activity.setDate(date);
                activityRepository.save(activity);
            });
        });
        return activities;
    }

    @Override
    public List<ActivityResponseDTO> getAllActivity() {
        List<Activity> activities = activityRepository.findAll();
        List<ActivityResponseDTO> list = new ArrayList<>();
        for (Activity activity : activities) {
            list.add(new ActivityResponseDTO(activity));
        }
        return list;
    }

    @Override
    public ActivityResponseDTO updateActivity(ActivityRequestDTO activityRequestDTO, UUID activityId) {
        Activity existedActivity = activityRepository.findById(activityId).orElseThrow(() -> new ActivityExceptions("Activity not found"));

        AssignResponseDTO assign = assignService.getAssignById(existedActivity.getAssign().getId());

        if(assign.getTerm().getStartAt().isAfter(activityRequestDTO.getDate()) || assign.getTerm().getEndAt().isBefore(activityRequestDTO.getDate())) {
            throw new ActivityExceptions("Activity date is not in range of term");
        }

        List<Activity> activities = activityRepository.findAll();

        activities.forEach(activity -> {
            if(activity.getDate().equals(activityRequestDTO.getDate()) && !activity.getId().equals(existedActivity.getId())) {
                if (activity.getSlot().getId().equals(activityRequestDTO.getSlotId()) && !activity.getId().equals(existedActivity.getId())) {
                    if ((activity.getInstructor().getId().equals(activityRequestDTO.getInstructorId())  || activity.getRoom().getId().equals(activityRequestDTO.getRoomId())) && !activity.getId().equals(existedActivity.getId())) {
                        throw new ActivityExceptions("Activity already exists");
                    }
                }
            }
        });
        Activity newActivity = activityRequestDTO.getActivity();

        existedActivity.setUpdateAt(LocalDateTime.now());
        existedActivity.setDate(newActivity.getDate());
        existedActivity.setSlot(newActivity.getSlot());
        existedActivity.setInstructor(newActivity.getInstructor());
        existedActivity.setRoom(newActivity.getRoom());

        return new ActivityResponseDTO(activityRepository.save(existedActivity));
    }

    @Override
    public ActivityResponseDTO getActivityById(UUID id) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ActivityExceptions("Activity not found"));
        if (activity == null) {
            return null;
        }
        return new ActivityResponseDTO(activity);
    }

    public  List<LocalDate> findWeekdaysInYear(int year, int weekNumber) {
        List<LocalDate> weekdays = new ArrayList<>();

        // Xác định ngày đầu tiên của năm và số tuần
        LocalDate firstDayOfYear = LocalDate.of(year, 1, 1);
        LocalDate firstDayOfGivenWeek = firstDayOfYear.plusWeeks(weekNumber - 1);

        // Thêm các ngày trong tuần vào danh sách kết quả
        for (int i = 0; i < 7; i++) {
            weekdays.add(firstDayOfGivenWeek.plusDays(i));
        }

        return weekdays;
    }



    @Override
    public List<ActivityResponseDTO> findActivityByStudentIdByWeekAndYear(Student studentId, Integer week, Integer year) {
        List<LocalDate> weekdays = findWeekdaysInYear(year, week);
        List<Activity> activities = activityRepository.findByAttendances_StudentAndDateIn(studentId, weekdays);
        List<ActivityResponseDTO> list = new ArrayList<>();
        for (Activity activity : activities) {
            list.add(new ActivityResponseDTO(activity));
        }
        return list;
    }

    @Override
    public List<ActivityResponseDTO> findActivityByAssignId(UUID assignId) {
        List<Activity> activities = activityRepository.findByAssignId(assignId);
        List<ActivityResponseDTO> list = new ArrayList<>();
        for (Activity activity : activities) {
            list.add(new ActivityResponseDTO(activity));
        }
        return list;
    }

    @Override
    public List<ActivityResponseDTO> findActivityByInstructorIdByWeekAndYear(Instructor instructor, Integer week, Integer year) {
        List<LocalDate> weekdays = findWeekdaysInYear(year, week);
        List<Activity> activities = activityRepository.findByInstructorAndDateIn(instructor, weekdays);
        List<ActivityResponseDTO> list = new ArrayList<>();
        for (Activity activity : activities) {
            list.add(new ActivityResponseDTO(activity));
        }
        return list;
    }
}
