package com.studentsapi.service;

import com.studentsapi.persitence.dto.StudentGetDto;
import com.studentsapi.persitence.dto.StudentSaveDto;

import com.studentsapi.persitence.mapper.StudentMapper;

import com.studentsapi.persitence.mapper.StudentMapperSaveEntity;
import com.studentsapi.persitence.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    private final StudentMapper mapper;

    private final StudentMapperSaveEntity mapperSave;

    public StudentService(StudentRepository repository, StudentMapper mapper, StudentMapperSaveEntity mapperSave) {
        this.repository = repository;
        this.mapper = mapper;
        this.mapperSave = mapperSave;
    }

    public List<StudentGetDto> finAllStudent() {
        return mapper.toDtoList(repository.findAll());
    }
    
    

    public Optional<StudentGetDto> findById(Long id) {

        return repository.findById(id).map(student -> mapper.toDto(student));
    }

    public StudentGetDto save(StudentSaveDto saveDto) {
        return mapper.toDto(repository.save(mapperSave.toEntity(saveDto)));

    }

}
