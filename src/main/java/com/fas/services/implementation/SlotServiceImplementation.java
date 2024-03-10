package com.fas.services.implementation;


import com.fas.models.dtos.requests.SlotRequestDTO;
import com.fas.models.dtos.responses.SlotResponseDTO;
import com.fas.models.entities.Slot;
import com.fas.models.exceptions.SlotExceptions;
import com.fas.repositories.SlotRepository;
import com.fas.services.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;




@Service
public class SlotServiceImplementation implements SlotService {


    @Autowired
    private SlotRepository slotRepository;
    @Override
    public SlotResponseDTO createSlot(SlotRequestDTO slotRequestDTO) {
        Slot slot = slotRequestDTO.getSlot();
        Slot checkSlot = slotRepository.findByName(slot.getName());
        if (checkSlot != null) {
            throw new SlotExceptions("Slot already exists");
        }
        Slot newSlot = slotRepository.save(slot);
        return new SlotResponseDTO(newSlot);
    }


    @Override
    public SlotResponseDTO updateSlot(SlotRequestDTO slotRequestDTO, UUID slotId) {
        Slot existedSlot = slotRepository.findById(slotId).get();
        if (existedSlot == null) {
            throw new SlotExceptions("Slot not found");
        }
        Slot newSlot = slotRequestDTO.getSlot();
        Slot checkSlot = slotRepository.findUniqueNameToUpdate(newSlot.getName(), slotId);
        if (checkSlot != null) {
            throw new SlotExceptions("Slot already exists");
        }
        existedSlot.setName(newSlot.getName());
        existedSlot.setStartAt(newSlot.getStartAt());
        existedSlot.setEndAt(newSlot.getEndAt());
        existedSlot.setUpdatedAt(LocalDateTime.now());


        Slot savedSlot = slotRepository.save(existedSlot);
        return new SlotResponseDTO(savedSlot);
    }


    @Override
    public SlotResponseDTO deleteSlot(UUID slotId) {
        Slot existedSlot = slotRepository.findById(slotId).get();
        if (existedSlot == null) {
            throw new SlotExceptions("Slot not found");
        }
        existedSlot.setUpdatedAt(LocalDateTime.now());
        existedSlot.setStatus(!existedSlot.isStatus());


        Slot savedSlot = slotRepository.save(existedSlot);
        return new SlotResponseDTO(savedSlot);
    }


    @Override
    public SlotResponseDTO getSlotById(UUID slotId) {
        Slot slot = slotRepository.findById(slotId).get();
        if (slot == null) {
            throw new SlotExceptions("Slot not found");
        }
        return new SlotResponseDTO(slot);
    }


    @Override
    public List<SlotResponseDTO> getAllSlots() {
        List<Slot> slots = slotRepository.findAll();
        List<SlotResponseDTO> slotResponseDTOS = new ArrayList<>();
        for (Slot slot : slots) {
            slotResponseDTOS.add(new SlotResponseDTO(slot));
        }
        return slotResponseDTOS;
    }
}
