package com.fas.services.implementation;

import com.fas.models.dtos.requests.ActivityRequestDTO;
import com.fas.models.dtos.responses.ActivityResponseDTO;
import com.fas.models.dtos.responses.AssignResponseDTO;
import com.fas.models.entities.Activity;
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

        existedActivity.setUpdateAt(LocalDateTime.now());

// Kiểm tra và gán giá trị cho Date
        if (activityRequestDTO.getActivity().getDate() != null) {
            existedActivity.setDate(activityRequestDTO.getActivity().getDate());
        }

// Kiểm tra và gán giá trị cho Assign
        if (activityRequestDTO.getActivity().getAssign() != null) {
            existedActivity.setAssign(activityRequestDTO.getActivity().getAssign());
        }

// Kiểm tra và gán giá trị cho Room
        if (activityRequestDTO.getActivity().getRoom() != null) {
            existedActivity.setRoom(activityRequestDTO.getActivity().getRoom());
        }

// Kiểm tra và gán giá trị cho Slot
        if (activityRequestDTO.getActivity().getSlot() != null) {
            existedActivity.setSlot(activityRequestDTO.getActivity().getSlot());
        }

// Kiểm tra và gán giá trị cho Instructor
        if (activityRequestDTO.getActivity().getInstructor() != null) {
            existedActivity.setInstructor(activityRequestDTO.getActivity().getInstructor());
        }


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
}
