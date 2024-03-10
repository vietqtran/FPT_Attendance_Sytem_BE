package com.fas.services;


import com.fas.models.dtos.requests.SlotRequestDTO;
import com.fas.models.dtos.responses.SlotResponseDTO;


import java.util.List;
import java.util.UUID;


public interface SlotService {


    SlotResponseDTO createSlot(SlotRequestDTO  slotRequestDTO);


    SlotResponseDTO updateSlot(SlotRequestDTO slotRequestDTO, UUID slotId);


    SlotResponseDTO deleteSlot(UUID slotId);


    SlotResponseDTO getSlotById(UUID slotId);


    List<SlotResponseDTO> getAllSlots();
}
