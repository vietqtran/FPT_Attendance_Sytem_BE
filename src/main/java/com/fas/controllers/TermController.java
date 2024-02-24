package com.fas.controllers;

import com.fas.models.dtos.requests.TermRequestDTO;
import com.fas.models.dtos.responses.StudentResponseDTO;
import com.fas.models.dtos.responses.TermResponseDTO;
import com.fas.models.entities.Student;
import com.fas.models.entities.Term;
import com.fas.models.enums.Code;
import com.fas.models.exceptions.StudentExceptions;
import com.fas.models.exceptions.TermExceptions;
import com.fas.models.utils.MessageDetails;
import com.fas.services.TermService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TermController {
    @Autowired
    private TermService termService;


    @PostMapping("/term")
    public MessageDetails<TermResponseDTO> createTerm(@Valid @RequestBody TermRequestDTO term) throws TermExceptions {
        TermResponseDTO newTerm = termService.createTerm(term);
        if(newTerm == null) {
            return new MessageDetails<>("Term created failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Term created successfully", newTerm, Code.SUCCESS);
    }

    @PutMapping("/term/update/{termId}")
    public MessageDetails<TermResponseDTO> updateTerm(@Valid @RequestBody TermRequestDTO term, @PathVariable UUID termId) throws StudentExceptions {
        TermResponseDTO updatedTerm = termService.updateTerm(term, termId);
        if(updatedTerm == null) {
            return new MessageDetails<>("Term updated failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Term updated successfully", termService.updateTerm(term, termId), Code.SUCCESS);
    }

    @PutMapping("/term/delete/{termId}")
    public MessageDetails<TermResponseDTO>  deleteTerm(@PathVariable UUID termId) throws StudentExceptions {
        TermResponseDTO term = termService.deleteTerm(termId);
        if(term == null) {
            return new MessageDetails<>("Term deleted failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Term deleted successfully", term, Code.SUCCESS);
    }

    @GetMapping("/term")
    public MessageDetails<List<TermResponseDTO>> getAllTerms() {
        List<TermResponseDTO> terms = termService.getAllTerms();
        if(terms == null) {
            return new MessageDetails<>("Get all terms failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get all terms successfully", termService.getAllTerms(), Code.SUCCESS);
    }

    @GetMapping("/term/{termId}")
    public MessageDetails<TermResponseDTO> getTermById(@PathVariable UUID termId) {
        Term term = termService.getTermById(termId);
        if(term == null) {
            return new MessageDetails<>("Get term failed", null, Code.FAILURE);
        }
        return new MessageDetails<>("Get term successfully", new TermResponseDTO(term), Code.SUCCESS);
    }
}
