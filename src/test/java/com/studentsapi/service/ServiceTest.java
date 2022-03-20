package com.studentsapi.service;

import com.studentsapi.persitence.dto.StudentGetDto;
import com.studentsapi.persitence.entity.Student;
import com.studentsapi.persitence.mapper.StudentMapper;
import com.studentsapi.persitence.mapper.StudentMapperSaveEntity;
import com.studentsapi.persitence.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class ServiceTest {

    @Mock
    private StudentRepository repositoryMock;
    @Mock
    private StudentMapper mapperMock;
    @Mock
    private StudentMapperSaveEntity mapperSaveMock;
    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Nested
    public class finAllStudent {
        @Test
        public void when_xx_then_success() throws Exception {

            List<Student> findAllReturnValue = new ArrayList();
            when(repositoryMock.findAll()).thenReturn(findAllReturnValue);

            List<StudentGetDto> toDtoListReturnValue = new ArrayList();
            when(mapperMock.toDtoList(new ArrayList())).thenReturn(toDtoListReturnValue);

            //2.Act
            List<StudentGetDto> finAllStudentRetReturnValue = studentService.finAllStudent();

            //3.Assert
            List<StudentGetDto> sutExpected = new ArrayList();
            assertEquals(sutExpected, finAllStudentRetReturnValue);
        }
    }
    @Nested
    public class findById {
        @Test
        public void when_xx_then_success_repository() throws Exception {
            Long id = 1L;
            Student student = new Student();
            student.setId(id);
            Optional<Student> findByIdReturnValue = Optional.of(student);
            when(repositoryMock.findById(1L)).thenReturn(findByIdReturnValue);

            StudentGetDto toDtoReturnValue = new StudentGetDto();
            toDtoReturnValue.setId(id);
            when(mapperMock.toDto(new Student())).thenReturn(toDtoReturnValue);
            assertEquals( toDtoReturnValue.getId() , findByIdReturnValue.get().getId());

        }
        @Test
        public void when_xx_then_success_service() throws Exception {
            Long id = 1L;
            StudentGetDto toDtoReturnValueService = new StudentGetDto();
            toDtoReturnValueService.setId(id);
            Optional<StudentGetDto> findByIdRetReturnValue = Optional.of(toDtoReturnValueService);
            when(studentService.findById(id)).thenReturn(findByIdRetReturnValue);

            StudentGetDto sutExpectedDTO = new StudentGetDto();
            sutExpectedDTO.setId(id);
            Optional<StudentGetDto> sutExpected = Optional.of(sutExpectedDTO);
            assertEquals(sutExpected.get().getId(), findByIdRetReturnValue.get().getId());
        }
    }

}
