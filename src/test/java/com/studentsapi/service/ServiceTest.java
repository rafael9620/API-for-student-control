package com.studentsapi.service;

import com.studentsapi.persitence.dto.StudentGetDto;
import com.studentsapi.persitence.dto.StudentSaveDto;
import com.studentsapi.persitence.entity.Student;
import com.studentsapi.persitence.mapper.StudentMapper;
import com.studentsapi.persitence.repository.StudentRepository;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class ServiceTest {

    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper mapper;

    @InjectMocks
    private StudentService service;

    private Student student;

    private StudentGetDto studentGetDto;
    
    private StudentSaveDto saveStudent;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        student = new Student();
        student.setId(20L);
        student.setName("Manuel");
        student.setLastName("Alto");
        student.setEmail("mauel@gmail.com");
        student.setLastModifiedBy("admin");
        student.setCreatedBy("admin");
        student.setCreateDate(LocalDateTime.now());
        student.setLastModifiedDate(LocalDateTime.now());
        student.setVersion(1);         
        
        studentGetDto = new StudentGetDto();
        studentGetDto.setId(1L);
        studentGetDto.setName("Manuel");
        studentGetDto.setLastName("Alto");
        studentGetDto.setEmail("mauel@gmail.com");
        studentGetDto.setLastModifiedBy("admin");
        studentGetDto.setCreatedBy("admin");
        studentGetDto.setCreateDate(String.valueOf(LocalDateTime.now()));
        studentGetDto.setLastModifiedDate(String.valueOf(LocalDateTime.now()));
        studentGetDto.setVersion(1);       
        
        
    }

    @Test
    void finAllStudent() {
        when(repository.findAll()).thenReturn(Arrays.asList(student));
        assertNotNull(repository.findAll());

    }
    
    @Test
    void finAllStudentService() {
        when(service.finAllStudent()).thenReturn(Arrays.asList(studentGetDto));
        assertNotNull(service.finAllStudent());
    }   

    @Test
    void findById() {
        Optional<StudentGetDto> result = service.findById(1L);
        assertEquals("1L", result.get().getId());
    }
}
