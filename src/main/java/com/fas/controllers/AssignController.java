package com.fas.controllers;
import com.fas.models.dtos.requests.ActivityRequestDTO;
import com.fas.models.dtos.requests.AssignAndActivityRequestDTO;
import com.fas.models.dtos.requests.AssignRequestDTO;
import com.fas.models.dtos.responses.AssignResponseDTO;
import com.fas.models.enums.Code;
import com.fas.models.utils.MessageDetails;
import com.fas.services.AssignService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;


@RestController
public class AssignController {


   @Valid
   private AssignRequestDTO assignRequestDTO;


   @Valid
   private ActivityRequestDTO activityRequestDTO;


   @Autowired
   private AssignService assignService;


   @PostMapping("/assign")
   private MessageDetails<AssignResponseDTO> createAssign(@RequestBody @Valid AssignAndActivityRequestDTO requestDTO) {
       AssignResponseDTO assign = assignService.createAssign(requestDTO.getAssignRequestDTO(), requestDTO.getActivityRequestDTO());
       if(assign == null) {
           return new MessageDetails<AssignResponseDTO>("Create assign failed", null, Code.FAILURE);
       }
       return new MessageDetails<AssignResponseDTO>("Create assign successfully", assign, Code.SUCCESS);
   }


   @GetMapping("/assign")
   private MessageDetails<List<AssignResponseDTO>> getAllAssigns() {
       List<AssignResponseDTO> assigns = assignService.getAllAssigns();
       if(assigns == null) {
           return new MessageDetails<List<AssignResponseDTO>>("Get all assign failed", null, Code.FAILURE);
       }
       return new MessageDetails<List<AssignResponseDTO>>("Get all assign successfully", assigns, Code.SUCCESS);
   }


   @GetMapping("/assign/{assignId}")
   private MessageDetails<AssignResponseDTO> getAssign(@PathVariable UUID assignId) {
       AssignResponseDTO assign = assignService.getAssignById(assignId);
       if(assign == null) {
           return new MessageDetails<AssignResponseDTO>("Get assign failed", null, Code.FAILURE);
       }
       return new MessageDetails<AssignResponseDTO>("Get assign successfully", assign, Code.SUCCESS);
   }


   @PutMapping("/assign/update/{assignId}")
   private MessageDetails<AssignResponseDTO> updateAssign(@RequestBody AssignRequestDTO assignRequestDTO, @PathVariable UUID assignId) {
       AssignResponseDTO assign = assignService.updateAssign(assignRequestDTO, assignId);
       if(assign == null) {
           return new MessageDetails<AssignResponseDTO>("Update assign failed", null, Code.FAILURE);
       }
       return new MessageDetails<AssignResponseDTO>("Update assign successfully", assign, Code.SUCCESS);
   }


   @PutMapping("/assign/delete/{assignId}")
   private MessageDetails<AssignResponseDTO> deleteAssign(@PathVariable UUID assignId) {
       AssignResponseDTO assign = assignService.deleteAssign(assignId);
       if(assign == null) {
           return new MessageDetails<AssignResponseDTO>("Delete assign failed", null, Code.FAILURE);
       }
       return new MessageDetails<AssignResponseDTO>("Delete assign successfully", assign, Code.SUCCESS);
   }
}
