package com.fas.services.implementation;

import com.fas.models.dtos.requests.TermRequestDTO;
import com.fas.models.dtos.responses.TermResponseDTO;
import com.fas.models.entities.Term;
import com.fas.models.exceptions.TermExceptions;
import com.fas.repositories.TermRepository;
import com.fas.services.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TermServiceImplementation implements TermService {

    @Autowired
    private TermRepository termRepository;

    @Override
    public TermResponseDTO createTerm(TermRequestDTO term) {
        Term newTerm = term.getTerm();

        Term checkTerm = termRepository.findTermByName(newTerm.getName());
        if(checkTerm != null) {
            throw new TermExceptions("Term already exists");
        }
        if(newTerm.getStartAt().isAfter(newTerm.getEndAt())) {
            throw new TermExceptions("Start date must be before end date");
        }
        Term savedTerm = termRepository.save(newTerm);
        return new TermResponseDTO(savedTerm);
    }

    @Override
    public TermResponseDTO updateTerm(TermRequestDTO term, UUID termId) {
        Term existedTerm = getTermById(termId);

        if(!existedTerm.isStatus()) {
            throw new TermExceptions("Not available to update");
        }
        Term newTerm = term.getTerm();
        Term checkTerm = termRepository.checkUniqueTermName(newTerm.getName(), termId);
        if(checkTerm != null) {
            throw new TermExceptions("Term already exists");
        }

        if(newTerm.getStartAt().isAfter(newTerm.getEndAt())) {
            throw new TermExceptions("Start date must be before end date");
        }
        existedTerm.setName(newTerm.getName());
        existedTerm.setStartAt(newTerm.getStartAt());
        existedTerm.setEndAt(newTerm.getEndAt());
        existedTerm.setUpdateAt(LocalDateTime.now());

        Term savedTerm = termRepository.save(existedTerm);
        return new TermResponseDTO(savedTerm);
    }

    @Override
    public Term getTermById(UUID id) {
        Optional<Term> term = termRepository.findById(id);
        if(term.isEmpty()) {
            throw new TermExceptions("Term not found");
        }
        return term.get();
    }

    @Override
    public TermResponseDTO deleteTerm(UUID termId) {
        Term existedTerm = getTermById(termId);

        existedTerm.setUpdateAt(LocalDateTime.now());
        existedTerm.setStatus(!existedTerm.isStatus());

        Term savedTerm = termRepository.save(existedTerm);

        TermResponseDTO termResponseDTO = new TermResponseDTO(savedTerm);
        return termResponseDTO;
    }

    @Override
    public List<TermResponseDTO> getAllTerms() {
        List<Term> terms = termRepository.findAll();
        List<TermResponseDTO> listTerms = new ArrayList<>();
        for(Term term:terms) {
            TermResponseDTO termResponseDTO = new TermResponseDTO(term);
            listTerms.add(termResponseDTO);
        }
        return listTerms;
    }
}