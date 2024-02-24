package com.fas.services;


import com.fas.models.dtos.requests.TermRequestDTO;
import com.fas.models.dtos.responses.TermResponseDTO;
import com.fas.models.entities.Term;
import com.fas.models.exceptions.TermExceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TermService {

    public TermResponseDTO createTerm(TermRequestDTO term);

    public TermResponseDTO updateTerm(TermRequestDTO term, UUID termId);


    public Term getTermById(UUID id);

    public TermResponseDTO deleteTerm(UUID termId);

    public List<TermResponseDTO> getAllTerms();

}
