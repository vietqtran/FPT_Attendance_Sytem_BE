package com.fas.controllers;


import com.fas.models.dtos.requests.MajorRequestDTO;
import com.fas.models.dtos.responses.MajorResponseDTO;
import com.fas.models.entities.Major;
import com.fas.models.utils.MessageDetails;
import com.fas.services.MajorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class MajorController {

    @Autowired
    private MajorService majorService;

    @PostMapping("/major")
    private MessageDetails<MajorResponseDTO>  createMajor(@RequestBody @Valid MajorRequestDTO majorReq) {
        MajorResponseDTO major = majorService.createMajor(majorReq);
        return new MessageDetails<MajorResponseDTO>("Major created successfully", major, "success");
    }


    @GetMapping("/major")
    private MessageDetails<List<MajorResponseDTO>> getAllMajor() {
        List<MajorResponseDTO> majors = majorService.getAllMajors();
        return new MessageDetails<List<MajorResponseDTO>>("Get all majors successfully", majors, "success");
    }

    @PutMapping("/major/{majorId}")
    private MessageDetails<MajorResponseDTO> updateMajor(@RequestBody MajorRequestDTO major,@PathVariable  UUID majorId) {
        MajorResponseDTO majorResponseDTO = majorService.updateMajor(major, majorId);
        return new MessageDetails<MajorResponseDTO>("Update major successfully", majorResponseDTO, "success");
    }

    @DeleteMapping("/major/{majorId}")
    private MessageDetails<MajorResponseDTO> deleteMajor(@PathVariable UUID majorId) {
        majorService.deleteMajor(majorId);
        return new MessageDetails<MajorResponseDTO>("Delete major successfully", null, "success");
    }
}
