package com.studentsapi.service;

import com.studentsapi.persitence.dto.StudentGetDto;
import com.studentsapi.persitence.entity.Student;
import com.studentsapi.persitence.mapper.StudentMapper;
import com.studentsapi.persitence.mapper.StudentMapperSaveEntity;
import com.studentsapi.persitence.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;


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

}
