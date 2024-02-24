package com.fas.services.implementation;

import com.fas.models.dtos.requests.MajorRequestDTO;
import com.fas.models.dtos.responses.MajorResponseDTO;
import com.fas.models.entities.Major;
import com.fas.models.exceptions.MajorExceptions;
import com.fas.repositories.MajorRepository;
import com.fas.services.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class MajorServiceImplementation implements MajorService {

    @Autowired
    private MajorRepository majorRepository;

    @Override
    public MajorResponseDTO createMajor(MajorRequestDTO majorReq) {
        Major newMajor = majorReq.getMajor();
        Major checkMajor = majorRepository.findByCode(newMajor.getCode());
        if(checkMajor != null) {
            throw new MajorExceptions("Major already exists");
        }
        Major savedMajor = majorRepository.save(newMajor);
        return new MajorResponseDTO(savedMajor);
    }

    @Override
    public MajorResponseDTO updateMajor(MajorRequestDTO major, UUID majorId) {
        Major existedMajor = getMajorById(majorId);

        if(!existedMajor.isStatus()) {
            throw new MajorExceptions("Not available to update");
        }

        Major newMajor = major.getMajor();
        Major checkMajor = majorRepository.findByUniqueCode(newMajor.getCode(), majorId);
        if(checkMajor != null) {
            throw new MajorExceptions("Major already exists");
        }
        existedMajor.setCode(newMajor.getCode());
        existedMajor.setName(newMajor.getName());
        existedMajor.setUpdateAt(LocalDateTime.now());

        Major savedMajor = majorRepository.save(existedMajor);
        return new MajorResponseDTO(savedMajor);
    }

    @Override
    public MajorResponseDTO deleteMajor(UUID majorId) {
        Major existedMajor = getMajorById(majorId);

        existedMajor.setUpdateAt(LocalDateTime.now());
        existedMajor.setStatus(!existedMajor.isStatus());

        Major savedMajor = majorRepository.save(existedMajor);

        MajorResponseDTO majorResponseDTO = new MajorResponseDTO(savedMajor);
        return majorResponseDTO;
    }

    @Override
    public Major getMajorById(UUID id) {
        Optional<Major> major = majorRepository.findById(id);
        if(major.isEmpty()) {
            throw new MajorExceptions("Major not found");
        }
        return major.get();
    }

    @Override
    public List<MajorResponseDTO> getAllMajors() {
        List<Major> majors = majorRepository.findAll();
        List<MajorResponseDTO> listMajors = new ArrayList<>();
        for(Major major:majors) {
            MajorResponseDTO majorResponseDTO = new MajorResponseDTO(major);
            listMajors.add(majorResponseDTO);
        }
        return listMajors;
    }
}
