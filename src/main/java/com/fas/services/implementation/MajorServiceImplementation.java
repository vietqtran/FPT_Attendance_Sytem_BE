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
        Major savedMajor = majorRepository.save(newMajor);
        return new MajorResponseDTO(savedMajor);
    }

    @Override
    public MajorResponseDTO updateMajor(MajorRequestDTO major, UUID majorId) {
        Major existedMajor = getMajorById(majorId);
        Major newMajor = major.getMajor();

        existedMajor.setCode(newMajor.getCode());
        existedMajor.setName(newMajor.getName());
        existedMajor.setUpdateAt(LocalDateTime.now());

        Major savedMajor = majorRepository.save(existedMajor);
        return new MajorResponseDTO(savedMajor);
    }

    @Override
    public void deleteMajor(UUID majorId) {
        Major existedMajor = getMajorById(majorId);
        majorRepository.delete(existedMajor);
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
