package com.fas.controllers;




import com.fas.models.dtos.requests.SlotRequestDTO;
import com.fas.models.dtos.responses.SlotResponseDTO;
import com.fas.models.enums.Code;
import com.fas.models.exceptions.StudentExceptions;
import com.fas.models.utils.MessageDetails;
import com.fas.services.SlotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@RestController
public class SlotController {


    @Autowired
    private SlotService slotService;


    @PostMapping("/slot")
    public MessageDetails<SlotResponseDTO> createSlot(@Valid @RequestBody SlotRequestDTO slotRequestDTO ) {
        SlotResponseDTO newTerm = slotService.createSlot(slotRequestDTO);
        if(newTerm == null) {
            return new MessageDetails<>("Slot created failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Slot created successfully", newTerm, Code.SUCCESS);
    }


    @PutMapping("/slot/update/{slotId}")
    public MessageDetails<SlotResponseDTO> updateSlot(@Valid @RequestBody SlotRequestDTO slotRequestDTO, @PathVariable UUID slotId) {
        SlotResponseDTO updatedTerm = slotService.updateSlot(slotRequestDTO, slotId);
        if(updatedTerm == null) {
            return new MessageDetails<>("Slot updated failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Slot updated successfully", updatedTerm, Code.SUCCESS);
    }


    @PutMapping("/slot/delete/{slotId}")
    public MessageDetails<SlotResponseDTO>  deleteSlot(@PathVariable UUID slotId) throws StudentExceptions {
        SlotResponseDTO term = slotService.deleteSlot(slotId);
        if(term == null) {
            return new MessageDetails<>("Slot deleted failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Slot deleted successfully", term, Code.SUCCESS);
    }


    @GetMapping("/slot")
    public MessageDetails<List<SlotResponseDTO>> getAllSlots() {
        List<SlotResponseDTO> slots = slotService.getAllSlots();
        if(slots == null) {
            return new MessageDetails<>("Get all Slot failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get all Slot successfully", slots, Code.SUCCESS);
    }


    @GetMapping("/slot/{slotId}")
    public MessageDetails<SlotResponseDTO> getSlotById(@PathVariable UUID slotId) {
        SlotResponseDTO slot = slotService.getSlotById(slotId);
        if(slot == null) {
            return new MessageDetails<>("Get slot failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get slot successfully",slot, Code.SUCCESS);
    }
}
