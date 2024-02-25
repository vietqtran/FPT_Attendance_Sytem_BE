package com.fas.controllers;


import com.fas.models.dtos.requests.AssignFeedBackRequestDTO;
import com.fas.models.dtos.requests.GradeRequestDTO;
import com.fas.models.dtos.responses.AssignFeedBackResponseDTO;
import com.fas.models.dtos.responses.GradeResponseDTO;
import com.fas.models.entities.Grade;
import com.fas.models.enums.Code;
import com.fas.models.utils.MessageDetails;
import com.fas.services.AssignFeedBackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AssignFeedBackController {

}
